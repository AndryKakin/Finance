package currencies

import (
	"Finance/Server/database"
	"fmt"
	"log"
	"net"
	"time"

	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

const (
	port = ":50052"
)

type server struct {
}

func (s *server) GetAll(ctx context.Context, in *CurrenciesRequest) (*CurrenciesResponse, error) {
	var result = "GetAll:" + time.Now().Format(time.UnixDate)
	fmt.Println(result)
	localCurrencies := database.GetCurrencies()
	currenciesDto := make([]*Currency, 0)

	for _, currencyDB := range localCurrencies {
		currency := new(Currency)
		currency.Code = currencyDB.Code
		currenciesDto = append(currenciesDto, currency)
	}

	return &CurrenciesResponse{Currencies: currenciesDto}, nil
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
