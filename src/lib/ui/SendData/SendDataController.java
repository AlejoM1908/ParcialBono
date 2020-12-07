//Java imports
package lib.ui.SendData;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.models.InformationModel;

//Proyect imports
import lib.ui.MainApp.MainAppController;

public class SendDataController {
    private SendDataView sendDataView;
    private SendDataModel sendDataModel;

    public SendDataController(SendDataView sendDataView, SendDataModel sendDataModel, MainAppController rootComponent) {
        this.sendDataView = sendDataView;
        this.sendDataModel = sendDataModel;
        this.sendDataModel.setRootComponent(rootComponent);
        
        this.sendDataView.setNamesOptions(this.sendDataModel.getSensorsNames());
        
        this.sendDataView.getBackButton().addMouseListener(new SendDataListener(this.sendDataView, this.sendDataModel,this.sendDataModel.getRootComponent()));
        this.sendDataView.getComboBox().addActionListener(new SendDataActionListener(sendDataView, sendDataModel));
        this.sendDataView.getSendButton().addMouseListener(new SendDataListener(this.sendDataView, this.sendDataModel,this.sendDataModel.getRootComponent()));
    }
    
    private class SendDataListener implements MouseListener{
        private SendDataView view;
        private SendDataModel model;
        private MainAppController rootComponent;

        public SendDataListener(SendDataView sendDataView, SendDataModel sendDataModel, MainAppController rootComponent) {
            this.view = sendDataView;
            this.model = sendDataModel;
            this.rootComponent = rootComponent;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == this.view.getBackButton()){
                rootComponent.BackButton();
                this.view.setInformation(this.model.clearFields());
                this.view.setNamesOptions(this.model.getSensorsNames());
            }
            else if (me.getSource() == this.view.getSendButton()){
                sendData();
                if (this.model.getError() <3){
                    this.view.setNamesOptions(this.model.getSensorsNames());
                }
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
            this.view.getBackButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getSendButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
    
    private class SendDataActionListener implements ActionListener{
        private final SendDataView view;
        private final SendDataModel model;

        public SendDataActionListener(SendDataView sendDataView, SendDataModel sendDataModel) {
            this.view = sendDataView;
            this.model = sendDataModel;
        }

        @Override
        public void actionPerformed(ActionEvent me) {
            String result = (String) this.view.getComboBox().getSelectedItem();
            
            if (!result.isEmpty())
                this.view.setInformation(this.model.getInformation(result));
            else
                this.view.setInformation(new InformationModel("", "", "", "", "", "", ""));
        }
        
    }
    
    private void sendData(){
        InformationModel info = new InformationModel(
            this.sendDataView.getNameField().getText(), this.sendDataView.getTypeField().getText(), 
            this.sendDataView.getMinimumField().getText(), this.sendDataView.getMaximumField().getText(), 
            this.sendDataView.getLocationField().getText(), this.sendDataView.getAverageField().getText(), 
            this.sendDataView.getHoursNumberField().getText()
        );
        
        info.setValue(this.sendDataView.getValueField().getText());
        info.setProcessing(this.sendDataView.getProcessingField().getText());
        
        this.sendDataModel.sendData(info);
    }
}
