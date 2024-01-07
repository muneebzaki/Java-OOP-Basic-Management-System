import javax.swing.*;
import java.awt.*;

public class WarehouseView {
    private JFrame frame;
    private JTextField location;
    private JTextField receivingDate;
    private JButton receive;

    public WarehouseView() {
        frame = new JFrame("Warehouse Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 6, 6));

        location = new JTextField();
        frame.add(createInputPanel("Warehouse Location: ", location));

        receivingDate = new JTextField();
        frame.add(createInputPanel("Date of Receiving: ", receivingDate));

        receive = new JButton("Receive Product");
        frame.add(receive);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private JPanel createInputPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void display() {
        frame.setVisible(true);
    }

    public JFrame getFrame() { return frame; }
    public JTextField getLocationField() { return location; }
    public JTextField getReceivingDateField() { return receivingDate; }
    public JButton getReceiveButton() { return receive; }
}
