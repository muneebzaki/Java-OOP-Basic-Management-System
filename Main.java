public class Main {
    public static void main(String[] args) {
            MenuModel model = new MenuModel();
            MenuView view = new MenuView();
            SharedModel sharedModel = new SharedModel();
            MenuController controller = new MenuController(view, model, sharedModel);
            view.display();
    }
}
