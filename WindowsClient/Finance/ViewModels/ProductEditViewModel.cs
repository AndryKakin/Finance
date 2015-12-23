using System.ComponentModel.Composition;
using System.Windows.Input;
using Microsoft.Practices.Prism.Commands;
using Models.Products;
using System.Collections.Generic;
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
            Products = new List<Product>();
        }

        public IEnumerable<Product> Products { get; set; }

        private void AddProduct()
        {
            var addPoductWindow = new AddProductWindowView();
            addPoductWindow.DataContext = new AddProductViewModel(_productManager);
            addPoductWindow.Show();
        }

        private void LoadAllProducts()
        {
            Products = _productManager.GetAllProducts();
            OnPropertyChanged(()=> Products);
        }

        public ICommand LoadProductCommand { get; set; }

        public ICommand AddProductCommand { get; set; }
    }
}
