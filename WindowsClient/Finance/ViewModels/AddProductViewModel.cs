using System;
using System.ComponentModel.Composition;
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
    [Export]
    public class AddProductViewModel : BindableBase
    {
        private ProductManager _productManager;

        public EventHandler OnClose;

        [ImportingConstructor]
        public AddProductViewModel(ProductManager productManager)
        {
            _productManager = productManager;
            SaveCommand = new DelegateCommand(AddProduct);
            ChooseImageCommand = new DelegateCommand(ExecuteMethod);
        }

        private void CloseWindow()
        {
            var onClose = OnClose;
            if (onClose != null)
            {
                onClose(this, new EventArgs());
            }
        }

        private Byte[] BitmapBytes { get; set; }

        private void ExecuteMethod()
        {
            OpenFileDialog fdlg = new OpenFileDialog();
            fdlg.Title = "Jpeg files";
            fdlg.Filter = "All files (*.jpg)|*.jpg|All files (*.jpg)|*.jpg";
            fdlg.FilterIndex = 2;
            fdlg.RestoreDirectory = true;
            if (fdlg.ShowDialog() == DialogResult.OK)
            {
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
                    memStream.Position = 0;
                    BitmapBytes = ReadFully(memStream);
                    TempBitmap = image;
                    OnPropertyChanged(() => TempBitmap);
                }
            }
            OnPropertyChanged(() => TempBitmap);
        }

        public static byte[] ReadFully(Stream input)
        {
            byte[] buffer = new byte[16 * 1024];
            using (MemoryStream ms = new MemoryStream())
            {
                int read;
                while ((read = input.Read(buffer, 0, buffer.Length)) > 0)
                {
                    ms.Write(buffer, 0, read);
                }
                return ms.ToArray();
            }
        }
        private void AddProduct()
        {
            _productManager.Add(new Product
            {
                Name = Name,
                Description = Description,
                Bitmap = BitmapBytes

            });
            CloseWindow();
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
