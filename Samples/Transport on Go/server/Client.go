package helloworld

import (
	"golang.org/x/net/context"
	"google.golang.org/grpc"
	"log"
)

const (
	address     = "localhost:50051"
	defaultName = "TESTED CONNECTION..."
)

func main() {
	// Set up a connection to the server.
	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()
	c := NewGreeterClient(conn)

	// Contact the server and print out its response.
	name := defaultName
	r, err := c.SayHello(context.Background(), &HelloRequest{Name: name})
	if err != nil {
		log.Fatalf("could not greet: %v", err)
	}
	log.Printf("Greeting: %s", r.Message)
}
