//Java imports
package lib.ui.MainApp;

//Proyect imports
import lib.ui.MainPage.MainPageController;
import lib.ui.MainPage.MainPageModel;
import lib.ui.MainPage.MainPageView;
import lib.ui.SendData.SendDataController;
import lib.ui.SendData.SendDataModel;
import lib.ui.SendData.SendDataView;
import lib.ui.ShowData.ShowDataController;
import lib.ui.ShowData.ShowDataModel;
import lib.ui.ShowData.ShowDataView;
import lib.ui.Test.TestController;
import lib.ui.Test.TestModel;
import lib.ui.Test.TestView;

public class MainAppModel {
    private final MainPageView mainPageView = new MainPageView();
    private final MainPageModel mainPageModel = new MainPageModel();
    private MainPageController mainPageController;
    
    private final SendDataView sendDataView = new SendDataView();
    private final SendDataModel sendDataModel = new SendDataModel();
    private SendDataController sendDataController;
    
    private final ShowDataView showDataView = new ShowDataView();
    private final ShowDataModel showDataModel = new ShowDataModel();
    private ShowDataController showDataController;
    
    private final TestView testView = new TestView();
    private final TestModel testModel = new TestModel();
    private TestController testController;
    
    protected void setMainPageController(MainPageController mainPageController){
        this.mainPageController = mainPageController;
    }
    
    protected void setSendDataController(SendDataController sendDataController){
        this.sendDataController = sendDataController;
    }
    
    protected void setShowDataController (ShowDataController showDataController){
        this.showDataController = showDataController;
    }
    
    protected void setTestController (TestController testController){
        this.testController = testController;
    }

    protected MainPageView getMainPageView() {return this.mainPageView;}
    protected MainPageModel getMainPageModel() {return this.mainPageModel;}
    protected MainPageController getMainPageController() {return this.mainPageController;}
    
    protected SendDataView getSendDataView() {return this.sendDataView;}
    protected SendDataModel getSendDataModel() {return this.sendDataModel;}
    protected SendDataController getSendDataController() {return this.sendDataController;}
    
    protected ShowDataView getShowDataView() {return this.showDataView;}
    protected ShowDataModel getShowDataModel() {return this.showDataModel;}
    protected ShowDataController getShowDataController() {return this.showDataController;}
    
    protected TestView getTestView() {return this.testView;};
    protected TestModel getTestModel() {return this.testModel;};
    protected TestController getTestController() {return this.testController;};
}
