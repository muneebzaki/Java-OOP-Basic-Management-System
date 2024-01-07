import java.util.ArrayList;

public class FactoryModel {
    private ArrayList<String[]> factoryDetails;

    public FactoryModel() {
        factoryDetails = new ArrayList<>();
    }

    public void addFoodItem(String name, String category, String expiry, String origin, String price) {
        factoryDetails.add(new String[]{name, category, expiry, origin, price});
    }
}
