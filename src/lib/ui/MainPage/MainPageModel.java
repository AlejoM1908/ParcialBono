//Java imports
package lib.ui.MainPage;

//Proyect imports
import lib.ui.MainApp.MainAppController;

public class MainPageModel {
    private MainAppController rootComponent;  
    
    protected void setRootComponent(MainAppController rootComponent){
        this.rootComponent = rootComponent;
    }
    
    protected MainAppController getRootComponent() {return this.rootComponent;}
}
