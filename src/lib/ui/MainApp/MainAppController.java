//Java imports
package lib.ui.MainApp;

import lib.ui.MainPage.MainPageController;
import lib.ui.SendData.SendDataController;
import lib.ui.ShowData.ShowDataController;
import lib.ui.Test.TestController;

public class MainAppController {
    private final MainAppView mainAppView;
    private final MainAppModel mainAppModel;

    public MainAppController(MainAppView mainAppView, MainAppModel mainAppModel) {
        this.mainAppView = mainAppView;
        this.mainAppModel = mainAppModel;
        
        //Placing the corresponding controller for the views
        this.mainAppModel.setMainPageController(new MainPageController(this.mainAppModel.getMainPageView(), this.mainAppModel.getMainPageModel(), this));
        this.mainAppModel.setSendDataController(new SendDataController(this.mainAppModel.getSendDataView(), this.mainAppModel.getSendDataModel(), this));
        this.mainAppModel.setShowDataController(new ShowDataController(this.mainAppModel.getShowDataView(), this.mainAppModel.getShowDataModel(), this));
        this.mainAppModel.setTestController(new TestController(this.mainAppModel.getTestView(), this.mainAppModel.getTestModel(), this));
        
        this.mainAppView.setMainPage(this.mainAppModel.getMainPageView());
    }
    
    public void BackButton(){
        this.mainAppView.setMainPage(this.mainAppModel.getMainPageView());
        
    }
    
    public void goToSendData(){
        this.mainAppView.setSendData(this.mainAppModel.getSendDataView());
    }
    
    public void goToShowData(){
        this.mainAppView.setShowData(this.mainAppModel.getShowDataView());
    }
    
    public void goToTest(){
        this.mainAppView.setTest(this.mainAppModel.getTestView());
    }
}
