package main

import (
	"fmt"
	"golang.org/x/net/context"
	"google.golang.org/grpc"
	"log"
	"net"
	"time"
)

const (
	port = ":50051"
)

type server struct{}

func (s *server) AddProduct(ctx context.Context, in *Product) (*ResultResponse, error) {
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
	return &ProductsResponse{}, nil
}

func main() {
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	RegisterProductServiceServer(s, &server{})
	s.Serve(lis)
}
