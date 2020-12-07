//Java imports
package lib.ui.Test;

import lib.ui.MainApp.MainAppController;

public class TestModel {
    private MainAppController rootComponent;
    
    protected void setRootComponent (MainAppController rootComponent){
        this.rootComponent = rootComponent;
    }
    
    protected MainAppController getRootComponent () {return this.rootComponent;}
}
