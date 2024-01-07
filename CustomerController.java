import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class CustomerController {
    private CustomerView view;
    private CustomerModel model;
    private SharedModel sharedModel;

    public CustomerController(CustomerView view, CustomerModel model, SharedModel sharedModel) {
        this.view = view;
        this.model = model;
        this.sharedModel = sharedModel;

        updateProductComboBox();

        view.getBuyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFrame().dispose();
                openRate();
            }
        });

        view.getMainMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFrame().dispose();
                openMainMenu();
            }
        });
    }

    private void updateProductComboBox() {
        view.clearProductComboBox();

        List<FoodItem> foodItems = sharedModel.getFoodItems();

        Set<String> productNames = new HashSet<>();
        for (FoodItem item : foodItems) {
            String productName = item.getName();
            if (!productNames.contains(productName)) {
                view.addProductToComboBox(productName);
                productNames.add(productName);
            }
        }
    }

    private void openMainMenu() {
        MenuModel menuModel = new MenuModel();
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView, menuModel, sharedModel);
        menuView.display();
    }

    private void openRate() {
        String selectedFoodName = (String) view.getProductComboBox().getSelectedItem();
        if (selectedFoodName != null && !selectedFoodName.isEmpty()) {
            FoodItem selectedFoodItem = sharedModel.getFoodItemByName(selectedFoodName);

            if (selectedFoodItem != null) {
                RateModel rateModel = new RateModel();
                RateView rateView = new RateView();
                RateController rateController = new RateController(rateView, rateModel, sharedModel);

                rateModel.setSelectedFoodItem(selectedFoodItem);
                rateView.displayFoodItemDetails(selectedFoodItem);
                rateView.display();
            }
        } else {
            JOptionPane.showMessageDialog(view.getFrame(), "Please select a food item from the list. ");
            openMainMenu();
        }
    }
}
