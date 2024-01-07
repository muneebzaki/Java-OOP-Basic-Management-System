import java.awt.event.*;
public class WarehouseController {
    private WarehouseView view;
    private WarehouseModel model;
    private SharedModel sharedModel;

    public WarehouseController(WarehouseView view, WarehouseModel model, SharedModel sharedModel) {
        this.view = view;
        this.model = model;
        this.sharedModel = sharedModel;

        view.getReceiveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = view.getLocationField().getText();
                String receivingDate = view.getReceivingDateField().getText();

                if (validateInputs(location, receivingDate)) {
                    FoodItem currentFoodItem = sharedModel.getCurrentFoodItem();

                    if (currentFoodItem != null) {

                    currentFoodItem.setWarehouseLocation(location);
                    currentFoodItem.setWarehouseReceivingDate(receivingDate);

                    sharedModel.addFoodItem(currentFoodItem);

                    view.getFrame().dispose();
                    openMainMenu();
                    }
                }
            }
        });
    }

    private boolean validateInputs(String location, String receivingDate) {
        try {

            if (location.isEmpty() || receivingDate.isEmpty()) {
                throw new IllegalArgumentException("Entry Fields cannot be empty.");
            }

            if (!receivingDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                throw new IllegalArgumentException("Invalid date format. Use YYYY-MM-DD.");
            }

            if (!isDateValid(receivingDate)) {
                throw new IllegalArgumentException("Expiry date must be in 2024, with months 01-12 and days 01-31.");
            }

            if (containsNumber(location)) {
                throw new IllegalArgumentException("Text Fields cannot contain numbers.");
            }
            return true;
        } catch (NumberFormatException e) {
            view.showError("Invalid price format. Please enter a valid number.");
            return false;
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
            return false;
        } catch (Exception e) {
            view.showError("Error");
            return false;
        }
    }

    public void openMainMenu() {
        MenuModel menuModel = new MenuModel();
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView, menuModel, sharedModel);
        menuView.display();
    }

    private boolean containsNumber(String text) {
        return text.matches(".*\\d.*");
    }

    private boolean isDateValid(String receivingDate) {
        if (!receivingDate.matches("\\d{4}-\\d{2}-\\d{2}"))
            return false;
        String[] parts = receivingDate.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return year == 2024 && month >= 1 && month <= 12 && day >= 1 && day <= 31;
    }
}
