import javax.swing.*;
import java.awt.*;

public class TransporterView {
    private JFrame frame;
    private JTextField transporterCompany;
    private JTextField foodSource;
    private JTextField foodDestination;
    private JTextField expectedDeliveryDate;
    private JButton addShippingDetails;

    public TransporterView() {
        frame = new JFrame("Transporter Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        transporterCompany = new JTextField();
        frame.add(createInputPanel("Transporter Company:", transporterCompany));

        foodSource = new JTextField();
        frame.add(createInputPanel("Food Source:", foodSource));

        foodDestination = new JTextField();
        frame.add(createInputPanel("Food Destination:", foodDestination));

        expectedDeliveryDate = new JTextField();
        frame.add(createInputPanel("Expected Delivery Date:", expectedDeliveryDate));

        addShippingDetails = new JButton("Add Shipping Details");
        frame.add(addShippingDetails);

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

    public JFrame getFrame() { return frame; }
    public JTextField getTransporterCompany() { return transporterCompany; }
    public JTextField getFoodSource() { return foodSource; }
    public JTextField getFoodDestination() { return foodDestination; }
    public JTextField getExpectedDeliveryDate() { return expectedDeliveryDate;}
    public JButton getAddShippingDetails() {
        return addShippingDetails;
    }
}