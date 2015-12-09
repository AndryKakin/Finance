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

// server is used to implement hellowrld.GreeterServer.
type server struct{}

// SayHello implements helloworld.GreeterServer
func (s *server) AddProduct(ctx context.Context, in *Product) (*ResultResponse, error) {
	fmt.Println(time.Now())
	fmt.Println(in.Name)
	return &ResultResponse{Status: 1}, nil
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
