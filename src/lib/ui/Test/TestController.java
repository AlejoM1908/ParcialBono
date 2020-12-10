//Java imports
package lib.ui.Test;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.models.InformationModel;
import lib.ui.MainApp.MainAppController;

public class TestController {
    private final TestView testView;
    private final TestModel testModel;

    public TestController(TestView testView, TestModel testModel, MainAppController rootComponent) {
        this.testView = testView;
        this.testModel = testModel;
        this.testModel.setRootComponent(rootComponent);
        
        this.testView.setComboData(this.testModel.getSensorsNames());
        
        this.testView.getProcessButton().addMouseListener(new TestControllerListener(testView, testModel));
        this.testView.getBackButton().addMouseListener(new TestControllerListener(testView, testModel));
    }
    
    private class TestControllerListener implements MouseListener{
        private final TestView view;
        private final TestModel model;

        public TestControllerListener(TestView testView, TestModel testModel) {
            this.view = testView;
            this.model = testModel;
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == this.view.getProcessButton()){
                String sensor = (String) this.view.getComboBox().getSelectedItem();
                
                if (sensor.isEmpty()){
                    this.view.showError(1);
                }
                else{
                    String id = sensor.split("-")[0];
                    
                    double value = this.model.getValue(Integer.parseInt(id));
                    
                    this.model.getMessage(Integer.parseInt(id), value);
                    
                    this.view.setAverage("" + value);
                    
                    this.view.showError(this.model.getError());
                }
            }
            else if (me.getSource() == this.view.getBackButton()){
                this.model.getRootComponent().BackButton();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            this.view.getProcessButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getBackButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
}
