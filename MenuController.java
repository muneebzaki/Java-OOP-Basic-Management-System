import java.awt.event.*;

public class MenuController {
    private MenuView view;
    private MenuModel model;
    private SharedModel sharedModel;

    public MenuController(MenuView view, MenuModel model, SharedModel sharedModel) {
        this.view = view;
        this.model = model;
        this.sharedModel = sharedModel;

        view.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFactoryPage();
            }
        });

        view.getCustomerPageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerPage();
            }
        });
    }

    private void openFactoryPage() {
        FactoryModel factoryModel = new FactoryModel();
        FactoryView factoryView = new FactoryView();
        FactoryController factoryController = new FactoryController(factoryView, factoryModel, sharedModel);

        factoryView.display();
        view.getFrame().dispose();
    }

    private void openCustomerPage() {
        CustomerModel customerModel = new CustomerModel();
        CustomerView customerView = new CustomerView();
        CustomerController customerController = new CustomerController(customerView, customerModel, sharedModel);

        customerView.display();
        view.getFrame().dispose();
    }
}
