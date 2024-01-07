import java.awt.event.*;

public class FactoryController {
    private FactoryView view;
    private FactoryModel model;
    private SharedModel sharedModel;

    public FactoryController(FactoryView view, FactoryModel model, SharedModel sharedModel) {
        this.view = view;
        this.model = model;
        this.sharedModel = sharedModel;

        view.getAddItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String foodName = view.getFoodName().getText();
                String foodCategory = view.getFoodCategory().getText();
                String expiryDate = view.getExpiryDate().getText();
                String countryOfOrigin = view.getCountryOfOrigin().getText();
                String foodPrice = view.getFoodPrice().getText();

                if (validateInputs(foodName,  foodCategory,  expiryDate,  countryOfOrigin,  foodPrice)) {
                   model.addFoodItem(foodName, foodCategory, expiryDate, countryOfOrigin, foodPrice);

                   FoodItem item = new FoodItem();
                   item.setName(view.getFoodName().getText());
                   item.setCategory(view.getFoodCategory().getText());
                   item.setExpiryDate(view.getExpiryDate().getText());
                   item.setCountryOfOrigin(view.getCountryOfOrigin().getText());
                   item.setPrice(view.getFoodPrice().getText());

                   sharedModel.addFoodItem(item);

                   view.getFrame().dispose();
                   openTransporterPage();
               }
            }
        });
    }

    private void openTransporterPage() {
        TransporterModel transporterModel = new TransporterModel();
        TransporterView transporterView = new TransporterView();
        TransporterController transporterController = new TransporterController(transporterView, transporterModel, sharedModel);
        transporterView.display();
    }
    private boolean validateInputs(String foodName, String foodCategory, String expiryDate, String countryOfOrigin, String foodPrice) {
        try {
            if (foodName.isEmpty() || foodCategory.isEmpty() || countryOfOrigin.isEmpty() || foodPrice.isEmpty()) {
                throw new IllegalArgumentException("Text Fields cannot be empty.");
            }

            if (!expiryDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                throw new IllegalArgumentException("Invalid date format. Use YYYY-MM-DD.");
            }

            if (!isDateValid(expiryDate)) {
                throw new IllegalArgumentException("Expiry date must be in 2024, with months 01-12 and days 01-31.");
            }

            double price = Double.parseDouble(foodPrice);
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative.");
            }

            if (containsNumber(foodName) || containsNumber(foodCategory) || containsNumber(countryOfOrigin)) {
                throw new IllegalArgumentException("Entry Fields cannot contain numbers.");
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
    private boolean containsNumber(String text) {
        return text.matches(".*\\d.*");
    }
    private boolean isDateValid(String expiryDate) {
        if (!expiryDate.matches("\\d{4}-\\d{2}-\\d{2}"))
            return false;
        String[] parts = expiryDate.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return year == 2024 && month >= 1 && month <= 12 && day >= 1 && day <= 31;
    }
}
