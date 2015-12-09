using System;
using Google.Protobuf.Products;
using Grpc.Core;

namespace gRPC_Client
{
    class Program
    {
        static void Main(string[] args)
        {
            Channel channel = new Channel("127.0.0.1:50051", Credentials.Insecure);

            var client = ProductService.NewClient(channel);

            var reply = client.AddProduct(new Product
            {
                Description = "dfdfgdfghdf",
                Name = "Bread"
            });
            Console.WriteLine("Greeting: " + reply.Status);

            channel.ShutdownAsync().Wait();
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
        }
    }
}
