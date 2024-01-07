public class RateModel {
    private String comments;
    private int rating;
    private FoodItem selectedFoodItem;

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setSelectedFoodItem(FoodItem item) {
        this.selectedFoodItem = item;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }

    public FoodItem getSelectedFoodItem() {
        return selectedFoodItem;
    }
}
