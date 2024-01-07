import javax.swing.*;
import java.awt.*;
public class MenuView {
    private JFrame frame;
    private JButton create;
    private JButton customerPage;

    public MenuView() {
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 1));

        JPanel panel = new JPanel(new GridLayout(1, 2, 20, 20));
        frame.add(panel);

        create = new JButton("Create Food Item");
        panel.add(create);

        customerPage = new JButton("Customer Page");
        panel.add(customerPage);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void display() {
        frame.setVisible(true);
    }
    public JFrame getFrame() {
        return frame;
    }

    public JButton getCreateButton() {
        return create;
    }

    public JButton getCustomerPageButton() {
        return customerPage;
    }
}
