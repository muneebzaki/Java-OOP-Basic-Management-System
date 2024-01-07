import javax.swing.*;
import java.awt.*;

public class FactoryView {
    private JFrame frame;
    private JTextField foodName;
    private JTextField foodCategory;
    private JTextField expiryDate;
    private JTextField countryOfOrigin;
    private JTextField foodPrice;
    private JButton addItem;

    public FactoryView() {
        frame = new JFrame("Factory Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));

        foodName = new JTextField();
        foodCategory = new JTextField();
        expiryDate = new JTextField();
        countryOfOrigin = new JTextField();
        foodPrice = new JTextField();
        addItem = new JButton("Add Food Item");

        frame.add(createInputPanel("Food Name:", foodName));
        frame.add(createInputPanel("Food Category:", foodCategory));
        frame.add(createInputPanel("Expiry Date:", expiryDate));
        frame.add(createInputPanel("Country of Origin:", countryOfOrigin));
        frame.add(createInputPanel("Food Price:", foodPrice));
        frame.add(addItem);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private JPanel createInputPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }

    public void display() {
        frame.setVisible(true);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public JFrame getFrame(){
        return frame;
    }
    public JButton getAddItem() { return addItem; }
    public JTextField getFoodName() { return foodName; }
    public JTextField getFoodCategory() { return foodCategory; }
    public JTextField getExpiryDate() { return expiryDate; }
    public JTextField getCountryOfOrigin() { return countryOfOrigin; }
    public JTextField getFoodPrice() { return foodPrice; }
}
