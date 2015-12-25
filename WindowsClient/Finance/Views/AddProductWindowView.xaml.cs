using Finance.ViewModels;
using Microsoft.Practices.ServiceLocation;
using Models.Products;

namespace Finance.Views
{
    /// <summary>
    /// Логика взаимодействия для AddProductWindowView.xaml
    /// </summary>
    public partial class AddProductWindowView
    {
        public AddProductWindowView()
        {
            InitializeComponent();
            DataContext = ServiceLocator.Current.GetInstance<AddProductViewModel>();
        }
    }
}
