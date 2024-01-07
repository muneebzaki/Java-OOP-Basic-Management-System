import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    private List<String> foodItems;

    public CustomerModel() {
        foodItems = new ArrayList<>();
    }

    public void addFoodItem(String item) {
        if (!foodItems.contains(item)) {
            foodItems.add(item);
        }
    }

    public List<String> getFoodItems() {
        return foodItems;
    }
}
