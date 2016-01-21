using Microsoft.Practices.ServiceLocation;
using System.Windows;
using Models.Products;

namespace Finance
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            var t = ServiceLocator.Current.GetInstance<ProductManager>();
        }
    }
}
