using System.Windows.Input;
using Microsoft.Practices.Prism.Commands;
using Microsoft.Practices.Prism.Mvvm;
using Models.Products;

namespace Finance.ViewModels
{
    public class AddProductViewModel : BindableBase
    {
        private ProductManager _productManager;
        public AddProductViewModel(ProductManager productManager)
        {
            _productManager = productManager;
            SaveCommand = new DelegateCommand(AddProduct);
        }

        private void AddProduct()
        {
            
        }

        public ICommand SaveCommand { get; set; }

        public ICommand CancelCommand { get; set; }

        public string Name { get; set; }

        public string Description { get; set; }


    }
}
