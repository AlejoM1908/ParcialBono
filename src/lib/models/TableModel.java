//Java imports
package lib.models;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

//Proyect Imports
import lib.services.DBConnection;

public class TableModel extends DefaultTableModel{
    DBConnection con = new DBConnection();
    

    public TableModel() {
        super();
        initializeTable();
    }
    
    private void initializeTable(){
        String[] titles = {"Nombre", "Valor", "Fecha y Hora", "Ubicación", "Processamiento"};
        setColumnIdentifiers(titles);
        
        con.getConnection();
        try{
            ResultSet result = con.executeQuery("select * from getLastHistory");
            con.endConnection();

            while (result.next()){
                String[] query = new String[5];
                
                query[0] = result.getString("name");
                query[1] = result.getString("value");
                query[2] = result.getString("dateTime");
                query[3] = result.getString("location");
                query[4] = result.getString("processing");
                
                addRow(query);
            }
        }
        catch(Exception e){
            
        }
    } 
        
    @Override
    public boolean isCellEditable (int row, int column){
        return false;
    }
}
