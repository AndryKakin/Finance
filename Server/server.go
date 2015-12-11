package main

import (
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
	myDb, err := db.OpenDB(MainDBPath)

	if err != nil {
		panic(err)
	}

	return myDb.Use(productStoreName)
}

func (s *server) AddProduct(ctx context.Context, in *Product) (*ResultResponse, error) {
	productStore := GetDbProductStore()
	docID, err := productStore.Insert(map[string]interface{}{
		"Name":        in.Name,
		"Description": in.Description,
		"Bitmap":      in.Bitmap})
	if err != nil {
		panic(err)
	}
	fmt.Println(docID)
	fmt.Println(time.Now())
	fmt.Println(in.Name)
	return &ResultResponse{Status: 1}, nil
}

func (s *server) UpdateProduct(ctx context.Context, in *Product) (*ResultResponse, error) {
	fmt.Println(time.Now())
	fmt.Println(in.Name)
	return &ResultResponse{Status: 1}, nil
}

func (s *server) DeleteProduct(ctx context.Context, in *Product) (*ResultResponse, error) {
	fmt.Println(time.Now())
	fmt.Println(in.Name)
	return &ResultResponse{Status: 1}, nil
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

func ServerGo() {
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	RegisterProductServiceServer(s, &server{})
	s.Serve(lis)
}
