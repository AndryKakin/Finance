using System;
using System.Collections.Generic;
using System.ComponentModel.Composition;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using Google.Protobuf;
using Google.Protobuf.products;
using Grpc.Core;
using Status = Google.Protobuf.products.Status;

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
            var request = new AddProductRequest
            {
                Name = productModel.Name,
                Description = productModel.Description,
                Bitmap = ByteString.CopyFrom(productModel.Bitmap),
                Code = "Test"
            };
            var result = client.Add(request);
            if(result.Status == Status.Failed)
                throw new Exception();
        }

        private static ByteString GetValue(Bitmap bitmap)
        {
            using (var newBitmap = new Bitmap(bitmap))
            {
                using (var memoryStream = new MemoryStream())
                {
                    newBitmap.Save(memoryStream, ImageFormat.Jpeg);
                    memoryStream.Position = 0;
                    return ByteString.CopyFrom(memoryStream.ToArray());
                }
            }
        }

        public IEnumerable<Product> GetAllProducts()
        {
            var channel = new Channel(_addresses, Credentials.Insecure);

            var client = ProductService.NewClient(channel);
            var results = client.GetAll(new ProductsRequest());
            return results.Products.Select(dtoProduct => new Product
            {
                Id = dtoProduct.Id,
                Name = dtoProduct.Name,
                Description = dtoProduct.Description,
                Bitmap = dtoProduct.Bitmap.ToByteArray()
            });
        }
    }
}
