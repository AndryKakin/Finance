using System;
using Finance.ViewModels;
using Microsoft.Practices.ServiceLocation;

namespace Finance.Views
{
    /// <summary>
    ///     Логика взаимодействия для AddProductWindowView.xaml
    /// </summary>
    public partial class AddProductWindowView
    {
        public AddProductWindowView()
        {
            InitializeComponent();
            var addProductViewModel = ServiceLocator.Current.GetInstance<AddProductViewModel>();
            addProductViewModel.OnClose += OnClose;
            DataContext = addProductViewModel;
        }

        private void OnClose(object sender, EventArgs eventArgs)
        {
            (DataContext as AddProductViewModel).OnClose -= OnClose;
            Close();
        }
    }
}