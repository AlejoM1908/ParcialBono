//Java imports
package lib.ui.Test;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import lib.services.DBConnection;
import lib.ui.MainApp.MainAppController;

public class TestModel {
    private MainAppController rootComponent;
    private DBConnection conn = new DBConnection();
    private int error;
    
    protected void setRootComponent (MainAppController rootComponent){
        this.rootComponent = rootComponent;
    }
    
    protected void setError (int error){
        this.error = error;
    }
    
    protected String[] getSensorsNames(){
        conn.getConnection();
        ArrayList<String> array = new ArrayList<>();
        array.add("");
        error = 0;
        
        try{
            ResultSet result = conn.executeQuery("select * from getNames");
            conn.endConnection();

            while (result.next()){
                array.add(result.getString("id") + "-" + result.getString("name"));
            }
            
            String[] resultString = new String[array.size()];
            
            for(int i = 0; i<array.size(); i++)
                    resultString[i] = array.get(i);
            
            return resultString;
        }
        catch(Exception e){
            error = 4;
            String[] resultString = {""};
            return resultString;
        }
    }
    
    protected double getValue(int id){
        this.conn.getConnection();
        
        try{
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            ResultSet result = this.conn.executeQuery("call processData(\"" + date + "\"," + id + ");");
            
            if (result.next()){
                this.conn.endConnection();
                return Double.parseDouble(result.getString("average"));
            }
        }
        catch(Exception e){
           
        }
        
        this.conn.endConnection();
        return 0; 
    }
    
    protected void getMessage(int id, double value){
        this.conn.getConnection();
        System.out.println(value);
        
        try{
            ResultSet result = this.conn.executeQuery("call getMessage(" + id + "," + value + ");");
            
            if (result.next()){
                this.error = Integer.parseInt(result.getString("message"));
                System.out.println(this.error);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        this.conn.endConnection();
    }
    
    protected MainAppController getRootComponent () {return this.rootComponent;}
    protected int getError() {return this.error;}
}
