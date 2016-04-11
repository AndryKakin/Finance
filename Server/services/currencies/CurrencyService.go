package currencies

import (
	"Finance/Server/database"
	"encoding/json"
	"fmt"
	"log"
	"net"
	"time"

	"github.com/HouzuoGuo/tiedot/db"
	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

const (
	port = ":50052"
)
const (
	currencyCode = "Code"
)

const (
	rubCurrency = "RUB"
)

const (
	usdCurrency = "USD"
)

var CurrencyStoreName = "Currency"

func GetDbCurrencyStore() *db.Col {
	mydb, err := db.OpenDB(database.MainDBPath)

	if err != nil {
		panic(err)
	}
	return mydb.Use(CurrencyStoreName)
}

func insertRubCurrency(store *db.Col) {
	haveItem := false

	store.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var currency Currency
		err := json.Unmarshal(docContent, &currency)
		if err != nil {
			panic(err)
		}

		if currency.Code == rubCurrency {
			haveItem = true
			return false
		} else {
			return true // move on to the next document OR
		}
	})

	if !haveItem {
		docID, err := store.Insert(map[string]interface{}{currencyCode: rubCurrency})
		if err != nil {
			panic(err)
		}
		fmt.Println("Create currency Id: %v  %v", docID, rubCurrency)
	}
	fmt.Println("Currency %v created early", rubCurrency)
}

func insertUsdCurrency(store *db.Col) {
	haveItem := false

	store.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var currency Currency
		err := json.Unmarshal(docContent, &currency)
		if err != nil {
			panic(err)
		}

		if currency.Code == usdCurrency {
			haveItem = true
			return false
		} else {
			return true // move on to the next document OR
		}
	})

	if !haveItem {
		docID, err := store.Insert(map[string]interface{}{currencyCode: usdCurrency})
		if err != nil {
			panic(err)
		}
		fmt.Println("Create currency Id: %v  %v", docID, usdCurrency)
	}
	fmt.Println("Currency %v created early", usdCurrency)
}

func InitializeCurrencies() {
	mydb, err := db.OpenDB(database.MainDBPath)

	if err != nil {
		panic(err)
	}
	database.CreateStore(CurrencyStoreName, mydb)
	currencyStore := mydb.Use(CurrencyStoreName)

	insertRubCurrency(currencyStore)
	insertUsdCurrency(currencyStore)

	defer mydb.Close()
}

type server struct{}

func (s *server) GetAll(ctx context.Context, in *CurrenciesRequest) (*CurrenciesResponse, error) {
	var result = "GetAll:" + time.Now().Format(time.UnixDate)
	fmt.Println(result)
	curencyStore := GetDbCurrencyStore()
	currencies := make([]*Currency, 0)

	curencyStore.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var currency Currency
		err := json.Unmarshal(docContent, &currency)
		if err != nil {
			panic(err)
		}
		currencies = append(currencies, &currency)
		fmt.Println("Id: v% Code: %v", id, currency.Code)
		return true
	})
	return &CurrenciesResponse{Currencies: currencies}, nil
}

func GoCurrencyService() {
	fmt.Println("Currency service starting...")
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	RegisterCurrencyServiceServer(s, &server{})
	s.Serve(lis)
	fmt.Println("Currency service started")
}
