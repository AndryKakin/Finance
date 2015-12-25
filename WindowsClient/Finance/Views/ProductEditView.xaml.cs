using Finance.ViewModels;
using Microsoft.Practices.ServiceLocation;
using System.Windows.Controls;

namespace Finance.Views
{
    /// <summary>
    /// Interaction logic for ProductEditView.xaml
    /// </summary>
    public partial class ProductEditView : UserControl
    {
        public ProductEditView()
        {
            InitializeComponent();
            ViewModel = ServiceLocator.Current.GetInstance<ProductEditViewModel>();
        }

        public ProductEditViewModel ViewModel
        {
            get { return (ProductEditViewModel)DataContext; }
            set
            {
                DataContext = value;
            }
        }
    }
}
