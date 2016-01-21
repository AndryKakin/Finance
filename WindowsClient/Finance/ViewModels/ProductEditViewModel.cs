using System.ComponentModel.Composition;
using System.Windows.Input;
using Microsoft.Practices.Prism.Commands;
using Models.Products;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using Finance.Views;
using Microsoft.Practices.Prism.Mvvm;

namespace Finance.ViewModels
{
    [Export]
    [PartCreationPolicy(CreationPolicy.Shared)]
    public class ProductEditViewModel : BindableBase
    {
        private readonly ProductManager _productManager;

        [ImportingConstructor]
        public ProductEditViewModel(ProductManager productManager)
        {
            _productManager = productManager;
            LoadProductCommand = new DelegateCommand(LoadAllProducts);
            AddProductCommand = new DelegateCommand(AddProduct);
            Products = new ObservableCollection<ProductViewModel>();
        }

        public IEnumerable<ProductViewModel> Products { get; set; }

        private void AddProduct()
        {
            var addPoductWindow = new AddProductWindowView();
            addPoductWindow.Show();
        }

        private void LoadAllProducts()
        {
            Products = _productManager.GetAllProducts()
                .Select(product => new ProductViewModel(product));

            OnPropertyChanged(()=> Products);
        }

        public ICommand LoadProductCommand { get; set; }

        public ICommand AddProductCommand { get; set; }
    }
}
