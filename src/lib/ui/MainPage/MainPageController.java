//Java imports
package lib.ui.MainPage;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.MainApp.MainAppController;

public class MainPageController {
    private final MainPageView mainPageView;
    private final MainPageModel mainPageModel;

    public MainPageController(MainPageView mainPageView, MainPageModel mainPageModel, MainAppController rootComponent) {
        this.mainPageView = mainPageView;
        this.mainPageModel = mainPageModel;
        this.mainPageModel.setRootComponent(rootComponent);
        
        //this.mainPageView.getTestButton().setVisible(false);
        
        this.mainPageView.getSendDataButton().addMouseListener(new MainPageListener(mainPageView, mainPageModel, rootComponent));
        this.mainPageView.getShowDataButton().addMouseListener(new MainPageListener(mainPageView, mainPageModel, rootComponent));
        this.mainPageView.getTestButton().addMouseListener(new MainPageListener(mainPageView, mainPageModel, rootComponent));
    }
    
    class MainPageListener implements MouseListener{
        private final MainPageView view;
        private final MainPageModel model;
        private final MainAppController rootComponent;

        public MainPageListener(MainPageView mainPageView, MainPageModel mainPageModel, MainAppController rootComponent) {
            this.view = mainPageView;
            this.model = mainPageModel;
            this.rootComponent = rootComponent;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == this.view.getSendDataButton()){
                this.rootComponent.goToSendData();
            }
            else if (me.getSource() == this.view.getShowDataButton()){
                this.rootComponent.goToShowData();
            }
            else if (me.getSource() == this.view.getTestButton()){
                this.rootComponent.goToTest();
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
            this.view.getSendDataButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getShowDataButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getTestButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
    
    public void backButton(){
        this.mainPageModel.getRootComponent().BackButton();
    }
}
