//Java imports
package lib.ui.Test;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import lib.utils.AppColors;

public class TestView extends javax.swing.JPanel {
    private AppColors colors = new AppColors();

    public TestView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        processButton = new javax.swing.JLabel();
        averageText = new javax.swing.JLabel();
        sensorsComboBox = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));

        processButton.setBackground(this.colors.buttonsColor());
        processButton.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        processButton.setForeground(new java.awt.Color(255, 255, 255));
        processButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        processButton.setText("Procesar datos");
        processButton.setOpaque(true);

        averageText.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        averageText.setForeground(this.colors.textColor());
        averageText.setBorder(javax.swing.BorderFactory.createLineBorder(this.colors.textColor()));

        sensorsComboBox.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        sensorsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/BackButton_38x38px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(380, 380, 380))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sensorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(averageText, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(backButton)
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(averageText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sensorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getProcessButton(){
        return this.processButton;
    }
    
    public void setComboData(String[] data){
        this.sensorsComboBox.setModel(new DefaultComboBoxModel(data));
    }
    
    public void setAverage(String average){
        this.averageText.setText(average);
    }
    
    public void showError(int error){
        switch(error){
            case 1: 
                JOptionPane.showMessageDialog(this, 
                        "Debes seleccionar algun sensor, porfavor selecciona uno");
            break;
            case 2: 
                JOptionPane.showMessageDialog(this, 
                        "El valor promedio es menor o igual que el minimo del sensor");
            break;
            case 3: 
                JOptionPane.showMessageDialog(this, 
                        "El valor promedio esta entre los valores minimos y maximos del sensor");
            break;
            case 4: 
                JOptionPane.showMessageDialog(this, 
                        "El valor promedio es mayor o igual al valor maximo");
            break;
            case 5: 
                JOptionPane.showMessageDialog(this, 
                        "Algo ocurrio mal, intenta nuevamnete!!");
            break;
        }
    }
    
    public JComboBox getComboBox() {return this.sensorsComboBox;}
    public JLabel getBackButton() {return this.backButton;}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel averageText;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel processButton;
    private javax.swing.JComboBox<String> sensorsComboBox;
    // End of variables declaration//GEN-END:variables
}