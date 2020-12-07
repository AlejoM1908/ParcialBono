//Java imports
package lib.ui.Test;

import lib.ui.MainApp.MainAppController;

public class TestController {
    private final TestView testView;
    private final TestModel testModel;

    public TestController(TestView testView, TestModel testModel, MainAppController rootComponent) {
        this.testView = testView;
        this.testModel = testModel;
        this.testModel.setRootComponent(rootComponent);
    }
    
    
}
