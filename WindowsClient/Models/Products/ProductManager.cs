using System.IO;
using Google.Protobuf;
using Google.Protobuf.Products;
using Grpc.Core;

namespace Models.Products
{
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
                //Bitmap = productModel.Bitmap.Save()
            };

            request.Bitmap = ByteString.CopyFrom(File.ReadAllBytes("Lighthouse.jpg"));
            var resuts = client.GetAll(new GetAllRequest());
        }
    }
}
