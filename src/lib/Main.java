//Java imports
package lib;

//Proyect imports
import lib.ui.MainApp.MainAppController;
import lib.ui.MainApp.MainAppModel;
import lib.ui.MainApp.MainAppView;

public class Main {
    private final MainAppView mainAppView = new MainAppView();
    private final MainAppModel mainAppModel = new MainAppModel();
    private final MainAppController mainAppController = new MainAppController(mainAppView,mainAppModel);

    public static void main(String args[]) {
        Main main = new Main();
        
        main.mainAppView.setVisible(true);
    }
    
    
}
