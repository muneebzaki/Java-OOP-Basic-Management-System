import java.util.ArrayList;

public class WarehouseModel {
    private ArrayList<String[]> warehouseDetails;

    public WarehouseModel() {
        warehouseDetails = new ArrayList<>();
    }

    public void addWarehouseDetail(String location, String receivingDate) {
        warehouseDetails.add(new String[]{location, receivingDate});
    }
}
