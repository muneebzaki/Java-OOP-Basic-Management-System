public class FoodItem {
    private String name;
    private String category;
    private String expiryDate;
    private String countryOfOrigin;
    private String price;
    private String transporterCompany;
    private String source;
    private String destination;
    private String expectedDeliveryDate;
    private String warehouseLocation;
    private String warehouseReceivingDate;

    public FoodItem() {
    }

    public FoodItem(String name, String category, String expiryDate, String countryOfOrigin,
                    String price, String transporterCompany, String source,
                    String destination, String expectedDeliveryDate,
                    String warehouseLocation, String warehouseReceivingDate) {
        this.name = name;
        this.category = category;
        this.expiryDate = expiryDate;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.transporterCompany = transporterCompany;
        this.source = source;
        this.destination = destination;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.warehouseLocation = warehouseLocation;
        this.warehouseReceivingDate = warehouseReceivingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTransporterCompany() {
        return transporterCompany;
    }

    public void setTransporterCompany(String transporterCompany) {
        this.transporterCompany = transporterCompany;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String getWarehouseReceivingDate() {
        return warehouseReceivingDate;
    }

    public void setWarehouseReceivingDate(String warehouseReceivingDate) {
        this.warehouseReceivingDate = warehouseReceivingDate;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nCategory: " + category +
                "\nExpiry Date: " + expiryDate +
                "\nOrigin: " + countryOfOrigin +
                "\nPrice: " + price + " $" +
                "\nTransporter: "+ transporterCompany +
                "\nSource: " + source +
                "\nDestination: " + destination +
                "\nEstimated Delivery Date: " + expectedDeliveryDate +
                "\nWarehouse Location: " + warehouseLocation +
                "\nWarehouse Estimated Date of Arrival: " + warehouseReceivingDate ;
    }
}
