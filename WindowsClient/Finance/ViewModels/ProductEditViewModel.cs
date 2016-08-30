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
        private ProductViewModel _selectedProduct;

        [ImportingConstructor]
        public ProductEditViewModel(ProductManager productManager)
        {
            _productManager = productManager;
            LoadProductCommand = new DelegateCommand(LoadAllProducts);
            AddProductCommand = new DelegateCommand(AddProduct);
            RemoveProductCommand = new DelegateCommand(RemoveProduct);
            Products = new ObservableCollection<ProductViewModel>();
        }

        private bool CanRemoveProduct()
        {
            return SelectedProduct != null;
        }

        private void RemoveProduct()
        {
            var selectedProduct = SelectedProduct;
            if (selectedProduct != null)
            {
                _productManager.Remove(selectedProduct.Id);
            }
        }

        public IEnumerable<ProductViewModel> Products { get; set; }

        public ProductViewModel SelectedProduct
        {
            get { return _selectedProduct; }
            set
            {
                if(_selectedProduct == value)
                    return;

                _selectedProduct = value;
                OnPropertyChanged(() => SelectedProduct);
            }
        }

        private void AddProduct()
        {
            var addPoductWindow = new AddProductWindowView();
            addPoductWindow.Show();
        }

        private void LoadAllProducts()
        {
            Products = new List<ProductViewModel>();
            Products = _productManager.GetAllProducts()
                .Select(product => new ProductViewModel(product));

            OnPropertyChanged(()=> Products);
        }

        public ICommand LoadProductCommand { get; set; }

        public ICommand AddProductCommand { get; set; }

        public ICommand RemoveProductCommand { get; set; }

    }
}
