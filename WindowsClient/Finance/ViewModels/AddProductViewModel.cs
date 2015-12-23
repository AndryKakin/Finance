using System.Drawing;
using System.IO;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using Microsoft.Practices.Prism.Commands;
using Microsoft.Practices.Prism.Mvvm;
using Models.Products;
using OpenFileDialog = System.Windows.Forms.OpenFileDialog;

namespace Finance.ViewModels
{
    public class AddProductViewModel : BindableBase
    {
        private ProductManager _productManager;
        public AddProductViewModel(ProductManager productManager)
        {
            _productManager = productManager;
            SaveCommand = new DelegateCommand(AddProduct);
            ChooseImageCommand = new DelegateCommand(ExecuteMethod);
        }

        private void ExecuteMethod()
        {
            OpenFileDialog fdlg = new OpenFileDialog();
            fdlg.Title = "C# Corner Open File Dialog";
            fdlg.Filter = "All files (*.*)|*.*|All files (*.*)|*.*";
            fdlg.FilterIndex = 2;
            fdlg.RestoreDirectory = true;
            if (fdlg.ShowDialog() == DialogResult.OK)
            {
                //ImageSource imageSource = new BitmapImage(new Uri(fdlg.FileName));

                //TempBitmap = imageSource;
                using (var memStream = File.Open(fdlg.FileName, FileMode.Open))
                {
                    Bitmap = new Bitmap(memStream);
                    memStream.Position = 0;
                    var image = new BitmapImage();
                    image.BeginInit();
                    image.StreamSource = memStream;
                    image.CacheOption = BitmapCacheOption.OnLoad;
                    image.EndInit();
                    image.Freeze();

                    TempBitmap = image;
                    OnPropertyChanged(() => TempBitmap);
                }
            }
            OnPropertyChanged(() => TempBitmap);
        }

        private void AddProduct()
        {
            _productManager.Add(new Product
            {
                Name = Name,
                Description = Description,
                Bitmap = Bitmap

            });
        }

        public Bitmap Bitmap { get; set; }
        public ICommand ChooseImageCommand { get; set; }

        public ICommand SaveCommand { get; set; }

        public ICommand CancelCommand { get; set; }

        public string Name { get; set; }

        public string Description { get; set; }

        public ImageSource TempBitmap { get; set; }

    }
}
