using System.Drawing;

namespace Models.Products
{
    public class Product
    {
        public long Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }

        public Bitmap Bitmap { get; set; }
    }
}