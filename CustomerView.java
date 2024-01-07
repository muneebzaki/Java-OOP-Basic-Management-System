import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomerView {
    private JFrame frame;
    private JComboBox<String> productComboBox;
    private JButton buyButton;
    private JButton mainMenuButton;

    public CustomerView() {
        frame = new JFrame("Customer Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,3,10,10));

        productComboBox = new JComboBox<>();
        frame.add(productComboBox);

        buyButton = new JButton("Buy");
        frame.add(buyButton);

        mainMenuButton = new JButton("Main Menu");
        frame.add(mainMenuButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void display() {
        frame.setVisible(true);
    }

    public void setProducts(List<String> products) {
        for (String product : products) {
            productComboBox.addItem(product);
        }
    }

    public void addProductToComboBox(String productName) {
        productComboBox.addItem(productName);
    }

    public void clearProductComboBox() {
        productComboBox.removeAllItems();
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JComboBox<String> getProductComboBox() {
        return productComboBox;
    }

    public void setProductComboBox(JComboBox<String> productComboBox) {
        this.productComboBox = productComboBox;
    }
}
