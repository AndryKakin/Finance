package services

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

func GetDbProductStore() *db.Col {
	myDb, err := db.OpenDB(database.MainDBPath)

	if err != nil {
		panic(err)
	}

	return myDb.Use(database.ProductStoreName)
}

func (s *server) Add(ctx context.Context, in *Product) (*ResultResponse, error) {
	productStore := GetDbProductStore()
	docID, err := productStore.Insert(map[string]interface{}{
		"Name":        in.Name,
		"Description": in.Description,
		"Bitmap":      in.Bitmap})
	if err != nil {
		panic(err)
	}
	fmt.Print("AddProduct: Id(%v) Time(%v) Name(%v)\n", docID, time.Now(), in.Name)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Update(ctx context.Context, in *Product) (*ResultResponse, error) {
	fmt.Print("UpdateProduct: Id(%v) Time(%v) Name(%v)\n", in.Id, time.Now(), in.Name)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Delete(ctx context.Context, in *Product) (*ResultResponse, error) {
	fmt.Print("DeleteProduct: Id(%v) Time(%v) Name(%v)\n", in.Id, time.Now(), in.Name)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) GetAll(ctx context.Context, in *GetAllRequest) (*ProductsResponse, error) {
	var result = "GetAll:" + time.Now().Format(time.UnixDate)
	fmt.Println(result)
	productStore := GetDbProductStore()
	products := make([]*Product, 0)

	productStore.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var product Product
		err := json.Unmarshal(docContent, &product)
		if err != nil {
			panic(err)
		}
		products = append(products, &product)
		fmt.Println("Id: %v Name: %v", product.Id, product.Name)
		return true  // move on to the next document OR
		return false // do not move on to the next document
	})
	return &ProductsResponse{Products: products}, nil
}

func GoProductService() {
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	RegisterProductServiceServer(s, &server{})
	s.Serve(lis)
}
