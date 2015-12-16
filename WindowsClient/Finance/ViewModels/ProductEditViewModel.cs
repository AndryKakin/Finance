using System;
using System.ComponentModel.Composition;
using System.Windows.Input;
using Microsoft.Practices.Prism.Commands;
using Models.Products;

namespace Finance.ViewModels
{
    [Export]
    [PartCreationPolicy(CreationPolicy.Shared)]
    public class ProductEditViewModel
    {
        private ProductManager _productManager;

        [ImportingConstructor]
        public ProductEditViewModel(ProductManager productManager)
        {
            _productManager = productManager;
            LoadProductCommand = new DelegateCommand(LoadAllProducts);
        }

        private void LoadAllProducts()
        {
            
        }

        public ICommand LoadProductCommand { get; set; }
    }
}
