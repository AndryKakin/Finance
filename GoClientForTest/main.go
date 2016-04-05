package main

import (
	"Finance/GoClientForTest/services/currencies"

	"log"

	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

const (
	address     = "localhost:50052"
	defaultName = "world"
)

func main() {

	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()

	currencyClient := currencies.NewCurrencyServiceClient(conn)

	currenciesRequest := new(currencies.CurrenciesRequest)

	r, err1 := currencyClient.GetAll(context.Background(), currenciesRequest)
	if err1 != nil {
		log.Fatalf("could not greet: %v", err1)
	}
	log.Printf("Greeting: %s", r.Currencies)
}
