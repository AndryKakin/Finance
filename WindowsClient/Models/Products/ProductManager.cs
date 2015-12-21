using System;
using System.Collections.Generic;
using System.ComponentModel.Composition;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using Google.Protobuf;
using Google.Protobuf.Products;
using Grpc.Core;
using Status = Google.Protobuf.Products.Status;

namespace Models.Products
{
    [Export]
    [PartCreationPolicy(CreationPolicy.Shared)]
    public class ProductManager
    {
        private string _addresses;
        public ProductManager()
        {
            _addresses = string.Format("{0}:{1}",
                Properties.Settings.Default.ServerAddress,
                Properties.Settings.Default.ServerPort);
        }

        public void Add(Product productModel)
        {
            Channel channel = new Channel(_addresses, Credentials.Insecure);
            
            var client = ProductService.NewClient(channel);
            var request = new Google.Protobuf.Products.Product
            {
                Name = productModel.Name,
                Description = productModel.Description,
                Bitmap = GetValue(productModel.Bitmap)
        };
            request.Bitmap = ByteString.CopyFrom(File.ReadAllBytes("Lighthouse.jpg"));
            var result = client.AddProduct(request);
            if(result.Status == Status.Failed)
                throw new Exception();
        }

        private static ByteString GetValue(Bitmap bitmap)
        {
            using (var memoryStream = new MemoryStream())
            {
                bitmap.Save(memoryStream, ImageFormat.Jpeg);
                memoryStream.Position = 0;
                return ByteString.CopyFrom(memoryStream.ToArray());
            }
        }

        public IEnumerable<Product> GetAllProducts()
        {
            Channel channel = new Channel(_addresses, Credentials.Insecure);

            var client = ProductService.NewClient(channel);
            var results = client.GetAll(new GetAllRequest());
            return results.Products.Select(dtoProduct =>
            {
                using (var memoryStream= new MemoryStream(dtoProduct.Bitmap.ToByteArray()))
                {
                    memoryStream.Position = 0;
                    return new Product
                    {
                        Id = dtoProduct.Id,
                        Name = dtoProduct.Name,
                        Description = dtoProduct.Description,
                        Bitmap = new Bitmap(memoryStream)
                    };
                }
            });
        }
    }
}
