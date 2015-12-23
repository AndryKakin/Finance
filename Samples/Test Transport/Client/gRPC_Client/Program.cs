using System;
using System.IO;
using Google.Protobuf;
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
            var request = new Product
            {
                Description = "dfdfgdfghdf",
                Name = "Bread",
            };
            request.Bitmap = ByteString.CopyFrom(File.ReadAllBytes("Lighthouse.jpg"));
            var t = client.AddProduct(request);


            var resuts = client.GetAll(new GetAllRequest());
            File.WriteAllBytes("Lighthouse1.jpg",resuts.Products[0].Bitmap.ToByteArray());
            channel.ShutdownAsync().Wait();
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
        }
    }
}
