import javax.swing.*;
import java.awt.event.*;

public class RateController {
    private RateView view;
    private RateModel model;
    private SharedModel sharedModel;

    public RateController(RateView view, RateModel model, SharedModel sharedModel) {
        this.view = view;
        this.model = model;
        this.sharedModel = sharedModel;

        FoodItem selectedFoodItem = model.getSelectedFoodItem();
        if (selectedFoodItem != null) {
            view.displayFoodItemDetails(selectedFoodItem);
        }

        view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setComments(view.getCommentField().getText());
                model.setRating((int) view.getRatingComboBox().getSelectedItem());

                if (view.getCommentField().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(view.getFrame(), "We would love if you left a comment.", "Empty Comment Field", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    model.setComments(view.getCommentField().getText());
                    model.setRating((int) view.getRatingComboBox().getSelectedItem());

                    String message =  model.getSelectedFoodItem().getName() + " Successfully Rated!! \nThank-you for buying with us!" +  "\nRating: " + model.getRating() + "\nComment: " + model.getComments();
                    JOptionPane.showMessageDialog(view.getFrame(), message, "Rating Information", JOptionPane.INFORMATION_MESSAGE);

                    view.getFrame().dispose();
                    openMainMenu();
                }
            }
        });

        view.getMainMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFrame().dispose();
                openMainMenu();
            }
        });
    }

    private void openMainMenu(){
        MenuModel menuModel = new MenuModel();
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView, menuModel, sharedModel);
        menuView.display();
    }
}
