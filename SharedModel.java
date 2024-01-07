import java.util.ArrayList;
import java.util.List;

public class SharedModel {
    private List<FoodItem> foodItems;

    public SharedModel() {
        foodItems = new ArrayList<>();
    }

    public void addFoodItem(FoodItem item) {
        foodItems.add(item);
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public FoodItem getFoodItemByName(String name) {
        for (FoodItem item : foodItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public FoodItem getCurrentFoodItem() {
        if (!foodItems.isEmpty()) {
            return foodItems.get(foodItems.size() - 1);
        }
        return null;
    }
}
