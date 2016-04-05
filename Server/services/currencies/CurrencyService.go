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

var CurrencyStoreName = "Currency"

func GetDbCurrencyStore() *db.Col {
	mydb, err := db.OpenDB(database.MainDBPath)

	if err != nil {
		panic(err)
	}
	return mydb.Use(CurrencyStoreName)
}

func InitializeCurrencies() {
	mydb, err := db.OpenDB(database.MainDBPath)

	if err != nil {
		panic(err)
	}
	database.CreateStore(CurrencyStoreName, mydb)
	defer mydb.Close()

	currencyStore := GetDbCurrencyStore()
	count := currencyStore.ApproxDocCount()
	fmt.Println("Currency: %v", count)

	if count < 1 {
		docID, err := currencyStore.Insert(map[string]interface{}{
			"Id":   1,
			"Name": "Rubli",
			"Code": "RUB"})
		if err != nil {
			panic(err)
		}
		fmt.Println("Create currency Id: %v", docID)
	}
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
		fmt.Println("Id: %v Name: %v", currency.Id, currency.Name)
		return true  // move on to the next document OR
		return false // do not move on to the next document
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
