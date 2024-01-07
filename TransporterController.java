import java.awt.event.*;

public class TransporterController {
    private TransporterView view;
    private TransporterModel model;
    private SharedModel sharedModel;

    public TransporterController(TransporterView view, TransporterModel model, SharedModel sharedModel) {
        this.view = view;
        this.model = model;
        this.sharedModel = sharedModel;

        view.getAddShippingDetails().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String company = view.getTransporterCompany().getText();
                String source = view.getFoodSource().getText();
                String destination = view.getFoodDestination().getText();
                String deliveryDate = view.getExpectedDeliveryDate().getText();

                if(validateInputs(company,source,destination,deliveryDate)) {
                    FoodItem currentFoodItem = sharedModel.getCurrentFoodItem();
                    if (currentFoodItem != null) {
                        currentFoodItem.setTransporterCompany(company);
                        currentFoodItem.setSource(source);
                        currentFoodItem.setDestination(destination);
                        currentFoodItem.setExpectedDeliveryDate(deliveryDate);
                        sharedModel.addFoodItem(currentFoodItem);

                        view.getFrame().dispose();
                        openWarehousePage();
                   }
                }
            }
        });
    }
    private boolean validateInputs(String company, String source, String destination, String deliveryDate) {
        try {

            if (company.isEmpty() || source.isEmpty() || destination.isEmpty() || deliveryDate.isEmpty()) {
                throw new IllegalArgumentException("Entry Fields cannot be empty.");
            }

            if (!deliveryDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                throw new IllegalArgumentException("Invalid date format. Use YYYY-MM-DD.");
            }

            if (!isDateValid(deliveryDate)) {
                throw new IllegalArgumentException("Expiry date must be in 2024, with months 01-12 and days 01-31.");
            }

            if (containsNumber(company) || containsNumber(source) || containsNumber(destination)) {
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
    private void openWarehousePage() {
        WarehouseModel warehouseModel = new WarehouseModel();
        WarehouseView warehouseView = new WarehouseView();
        WarehouseController warehouseController = new WarehouseController(warehouseView, warehouseModel, sharedModel);
        warehouseView.display();
    }

    private boolean containsNumber(String text) {
        return text.matches(".*\\d.*");
    }
    private boolean isDateValid(String deliveryDate) {
        if (!deliveryDate.matches("\\d{4}-\\d{2}-\\d{2}"))
            return false;
        String[] parts = deliveryDate.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return year == 2024 && month >= 1 && month <= 12 && day >= 1 && day <= 31;
    }
}
