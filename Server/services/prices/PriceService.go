package prices

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

type server struct{}

func GetDbPriceStore() *db.Col {
	myDb, err := db.OpenDB(database.MainDBPath)

	if err != nil {
		panic(err)
	}

	return myDb.Use(database.PriceStoreName)
}

func (s *server) Add(ctx context.Context, in *Price) (*ResultResponse, error) {
	productStore := database.GetDbPriceStore()
	docID, err := productStore.Insert(map[string]interface{}{
		"Price":      in.Price,
		"FkProduct":  in.FkProduct,
		"FkPurchase": in.FkPurchase})
	if err != nil {
		panic(err)
	}
	fmt.Print("AddPrice: Id(%v) Time(%v) Price(%v)\n", docID, time.Now(), in.Price)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Update(ctx context.Context, in *Price) (*ResultResponse, error) {
	fmt.Print("UpdatePrice: Id(%v) Time(%v) Price(%v)\n", in.Id, time.Now(), in.Price)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Delete(ctx context.Context, in *Price) (*ResultResponse, error) {
	fmt.Print("DeletePrice: Id(%v) Time(%v) Price(%v)\n", in.Id, time.Now(), in.Price)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) GetAll(ctx context.Context, in *GetAllRequest) (*PricesResponse, error) {
	var result = "GetAll:" + time.Now().Format(time.UnixDate)
	fmt.Println(result)
	productStore := database.GetDbProductStore()
	prices := make([]*Price, 0)

	productStore.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var price Price
		err := json.Unmarshal(docContent, &price)
		if err != nil {
			panic(err)
		}
		prices = append(prices, &price)
		fmt.Println("Id: %v Price: %v", price.Id, price.Price)
		return true  // move on to the next document OR
		return false // do not move on to the next document
	})
	return &PricesResponse{Prices: prices}, nil
}

func GoPriceService() {
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	RegisterPriceServiceServer(s, &server{})
	s.Serve(lis)
}
