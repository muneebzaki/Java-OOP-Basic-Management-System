import java.util.ArrayList;

public class TransporterModel {
    private ArrayList<String[]> transporterDetails;

    public TransporterModel() {
        transporterDetails = new ArrayList<>();
    }

    public void addTransporterDetails(String company, String source, String destination, String deliveryDate) {
        transporterDetails.add(new String[]{company, source, destination, deliveryDate});
    }
}
