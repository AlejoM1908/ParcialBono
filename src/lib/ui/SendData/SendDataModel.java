//Java imports
package lib.ui.SendData;

//Proyect imports
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import lib.models.InformationModel;
import lib.services.DBConnection;
import lib.ui.MainApp.MainAppController;

public class SendDataModel {
    private DBConnection conn = new DBConnection();
    private MainAppController rootComponent;
    private int error = 0;
    
    protected void setRootComponent(MainAppController rootComponent){
        this.rootComponent = rootComponent;
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
    
    protected InformationModel getInformation(String string){
        this.conn.getConnection();
        
        try{
            ResultSet result = conn.executeQuery("call getSensorInfo(" + string.split("-")[0] + ")");
            conn.endConnection();
            
            if (result.next()){
                return  new InformationModel(
                    result.getString("name"), 
                    result.getString("type"), 
                    result.getString("minimum"), 
                    result.getString("maximum"), 
                    result.getString("location"), 
                    result.getString("average"), 
                    result.getString("hoursNumber")
                );
            }
            else 
                return new InformationModel("", "", "", "", "", "", "");
        }
        catch(Exception e){
            conn.endConnection();
            return null;
        }
    }
    
    protected void sendData(InformationModel info){
        String string = "call insertData(\"" + info.getName() + "\",\"" + info.getType() + 
                "\"," + info.getMinimum()+ "," + info.getMaximum() + ",\"" + info.getLocation() + 
                "\",";
        if (!info.getAverage().isEmpty()){
            string += info.getAverage() + ",";
        }
        else
            string += "null,";
        
        if (!info.getHoursNumber().isEmpty()){
            string += info.getHoursNumber()+ ",";
        }
        else
            string += "null,";
        
        string += info.getValue() + ",\"" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\",\"";
        
        string += info.getProcessing() + "\")";
        
        conn.getConnection();
        try{
            ResultSet result = conn.executeQuery(string);

            if (result.next()){
                error = Integer.parseInt(result.getString("error"));
            }
        }
        catch (Exception e){
            
        }
    }
    
    protected InformationModel clearFields(){
        InformationModel infModel = new InformationModel("", "", "", "", "", "", "");
        infModel.setValue("");
        infModel.setProcessing("");
        
        return infModel;
    }
    
    protected MainAppController getRootComponent() {return this.rootComponent;}
    protected DBConnection getDBConnection() {return this.conn;}
    protected int getError() {return this.error;}
}
