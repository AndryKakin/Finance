package products

import (
	"Finance/Server/database/Products"
	"encoding/json"
	"fmt"
	"log"
	"net"
	"time"

	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

const (
	port = ":50053"
)

type server struct{}

func (s *server) Add(ctx context.Context, in *AddProductRequest) (*ResultResponse, error) {
	productDB := new(Products.ProductDB)
	productDB.Name = in.Name
	productDB.Code = in.Code
	productDB.Description = in.Description
	productDB.Bitmap = in.Bitmap

	docID := Products.Add(productDB)

	fmt.Print("AddProduct: Id(%v) Time(%v) Name(%v)\n", docID, time.Now(), in.Name)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Update(ctx context.Context, in *Product) (*ResultResponse, error) {
	fmt.Print("UpdateProduct: Id(%v) Time(%v) Name(%v)\n", in.Id, time.Now(), in.Name)
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) Delete(ctx context.Context, in *RemoveProductRequest) (*ResultResponse, error) {
	productStore := Products.GetDbProductStore()
	err := productStore.Delete(int(in.Id))
	if err != nil {
		fmt.Print("DeleteProduct: Id %v  Time %v FAILED (%v)\n", in.Id, time.Now(), err.Error())
		return &ResultResponse{Status: Status_Failed}, nil
	}

	fmt.Print("DeleteProduct: Id %v Time %v \n", in.Id, time.Now())
	return &ResultResponse{Status: Status_Ok}, nil
}

func (s *server) GetAll(ctx context.Context, in *ProductsRequest) (*ProductsResponse, error) {
	var result = "GetAll:" + time.Now().Format(time.UnixDate)
	fmt.Println(result)
	productStore := Products.GetDbProductStore()
	products := make([]*Product, 0)

	productStore.ForEachDoc(func(id int, docContent []byte) (willMoveOn bool) {
		var product Product
		err := json.Unmarshal(docContent, &product)
		product.Id = int64(id)
		if err != nil {
			panic(err)
		}
		products = append(products, &product)
		fmt.Println("Id: %v Name: %v", id, product.Name)
		return true  // move on to the next document OR
		return false // do not move on to the next document
	})
	return &ProductsResponse{Products: products}, nil
}

func GoProductService() {
	fmt.Println("Product service starting...")
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	RegisterProductServiceServer(s, &server{})
	s.Serve(lis)
	fmt.Println("Product service started")
}
