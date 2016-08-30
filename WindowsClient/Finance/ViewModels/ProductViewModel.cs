using System.IO;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using Microsoft.Practices.Prism.Mvvm;
using Models.Products;

namespace Finance.ViewModels
{
    public class ProductViewModel : BindableBase
    {
        private readonly Product _model;

        public ProductViewModel(Product product)
        {
            _model = product;
            using (var memStream= new MemoryStream(_model.Bitmap))
            {
                memStream.Position = 0;
                var image = new BitmapImage();
                image.BeginInit();
                image.StreamSource = memStream;
                image.CacheOption = BitmapCacheOption.OnLoad;
                image.EndInit();
                image.Freeze();

                Image = image;
            }
        }

        public string Name
        {
            get { return _model.Name; }
        }

        public ImageSource Image { get; }

        public long Id { get { return _model.Id; } }
    }
}