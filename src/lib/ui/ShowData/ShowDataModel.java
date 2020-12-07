//Java imports
package lib.ui.ShowData;
import lib.models.TableModel;

//Proyect imports
import lib.ui.MainApp.MainAppController;

public class ShowDataModel {
    private MainAppController rootComponent;

    protected void setRootComponent(MainAppController rootComponent){
        this.rootComponent = rootComponent;
    }
    
    protected TableModel getTable(){
        TableModel table = new TableModel();
        
        return table;
    }
    
    public MainAppController getRootComponent() {return this.rootComponent;}
}
