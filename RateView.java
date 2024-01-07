import javax.swing.*;
import java.awt.*;

public class RateView {
    private JFrame frame;
    private JTextArea infoTextArea;
    private JTextField commentField;
    private JComboBox<Integer> ratingComboBox;
    private JButton submitButton;
    private JButton mainMenuButton;

    public RateView() {
        frame = new JFrame("Rate Page");
        frame.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        infoTextArea = new JTextArea(8, 20);
        infoTextArea.setEditable(false);
        frame.add(new JScrollPane(infoTextArea));

        commentField = new JTextField();
        ratingComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        submitButton = new JButton("Submit");
        mainMenuButton = new JButton("Main Menu");

        JPanel panel = new JPanel(new GridLayout(1, 4));
        panel.add(new JLabel("Comment:"));
        panel.add(commentField);
        panel.add(new JLabel("Rating:"));
        panel.add(ratingComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(mainMenuButton);

        frame.add(panel);
        frame.add(buttonPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void display() {
        frame.setVisible(true);
    }

    public JFrame getFrame() { return frame; }
    public JTextField getCommentField() { return commentField; }
    public JComboBox<Integer> getRatingComboBox() { return ratingComboBox; }
    public JButton getSubmitButton() { return submitButton; }
    public JButton getMainMenuButton() { return mainMenuButton; }
    public JTextArea getInfoTextArea() { return infoTextArea; }

    public void displayFoodItemDetails(FoodItem item) {
        infoTextArea.setText(item.toString());
    }
}
