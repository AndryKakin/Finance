package purchases

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
	port = ":50054"
)

var PurchaseStoreName = "Purchase"

func GetDbPurchaseStore() *db.Col {
	mydb, err := db.OpenDB(database.MainDBPath)

	if err != nil {
		panic(err)
	}
	return mydb.Use(PurchaseStoreName)
}

type server struct{}

func (s *server) Add(ctx context.Context, in *Purchase) (*ResultResponse, error) {
	purchaseStore := GetDbPurchaseStore()
	docID, err := purchaseStore.Insert(map[string]interface{}{
		"FkCurrency": in.FkCurrency,
		"Id":         in.Id,
		"DateTime":   in.DateTime})
	if err != nil {
		panic(err)
	}
	fmt.Print("AddPurchase: Id(%v) Time(%v) FkCurrency(%v)\n", docID, time.Now(), in.FkCurrency)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Update(ctx context.Context, in *Purchase) (*ResultResponse, error) {
	fmt.Print("UpdatePurchase: Id(%v) Time(%v) FkCurrency(%v)\n", in.Id, time.Now(), in.FkCurrency)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Delete(ctx context.Context, in *Purchase) (*ResultResponse, error) {
	fmt.Print("DeletePurchase: Id(%v) Time(%v) FkCurrency(%v)\n", in.Id, time.Now(), in.FkCurrency)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) GetAll(ctx context.Context, in *GetAllRequest) (*PurchasesResponse, error) {
	var result = "GetAll:" + time.Now().Format(time.UnixDate)
	fmt.Println(result)
	purchaseStore := GetDbPurchaseStore()
	purchases := make([]*Purchase, 0)

	purchaseStore.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var purchase Purchase
		err := json.Unmarshal(docContent, &purchase)
		if err != nil {
			panic(err)
		}
		purchases = append(purchases, &purchase)
		fmt.Println("Id: %v FkCurrency: %v", purchase.Id, purchase.FkCurrency)
		return true  // move on to the next document OR
		return false // do not move on to the next document
	})
	return &PurchasesResponse{Purchases: purchases}, nil
}

func GoPurchasesService() {
	fmt.Println("Purchase service starting...")
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	RegisterPurchaseServiceServer(s, &server{})
	s.Serve(lis)
	fmt.Println("Purchase service started")
}
