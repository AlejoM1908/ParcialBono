//Java imports
package lib.ui.ShowData;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import lib.ui.MainApp.MainAppController;

public class ShowDataController {
    private final ShowDataView showDataView;
    private final ShowDataModel showDataModel;
    
    public ShowDataController(ShowDataView showDataView, ShowDataModel showDataModel, MainAppController rootComponent){
        this.showDataView = showDataView;
        this.showDataModel = showDataModel;
        this.showDataModel.setRootComponent(rootComponent);
        
        this.showDataView.getShowButton().addMouseListener(new ShowDataListener(this.showDataView, this.showDataModel));
        this.showDataView.getBackButton().addMouseListener(new ShowDataListener(this.showDataView, this.showDataModel));
    }
    
    private class ShowDataListener implements MouseListener{
        private final ShowDataView view;
        private final ShowDataModel model;

        public ShowDataListener(ShowDataView showDataView, ShowDataModel showDataModel) {
            this.view = showDataView;
            this.model = showDataModel;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == this.view.getShowButton()){
                this.view.setTable(this.model.getTable());
                this.view.updateUI();
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
            this.view.getShowButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getBackButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
        
    }
}
