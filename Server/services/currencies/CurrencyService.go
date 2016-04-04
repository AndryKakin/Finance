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
	port = ":50051"
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
	curencyStore := GetDbCurrencyStore()
	curencyStore.Index()
}

type server struct{}

func (s *server) Add(ctx context.Context, in *Currency) (*ResultResponse, error) {
	currencyStore := GetDbCurrencyStore()
	docID, err := currencyStore.Insert(map[string]interface{}{
		"Name": in.Name,
		"Code": in.Code})
	if err != nil {
		panic(err)
	}
	fmt.Print("AddCurrency: Id(%v) Time(%v) Name(%v)\n", docID, time.Now(), in.Name)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Update(ctx context.Context, in *Currency) (*ResultResponse, error) {
	fmt.Print("UpdateCurrency: Id(%v) Time(%v) Name(%v)\n", in.Id, time.Now(), in.Name)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Delete(ctx context.Context, in *Currency) (*ResultResponse, error) {
	fmt.Print("DeleteCurrency: Id(%v) Time(%v) Name(%v)\n", in.Id, time.Now(), in.Name)
	return &ResultResponse{Status: Status_Ok}, nil
}

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
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	RegisterCurrencyServiceServer(s, &server{})
	s.Serve(lis)
}
