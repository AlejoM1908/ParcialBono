//Java imports
package lib.models;

public class InformationModel {
    private final String name;
    private final String type;
    private final String minimum;
    private final String maximum;
    private final String location;
    private final String average;
    private final String hoursNumber;
    private String value;
    private String processing;
    
    public InformationModel(String name, String type, String minimum, String maximum, String location, String average, String hoursNumber){
        this.name = name;
        this.type = type;
        this.minimum = minimum;
        this.maximum = maximum;
        this.location = location;
        this.average = average;
        this.hoursNumber = hoursNumber;
    }
    
    public void setValue(String value){
        this.value = value;
    }
    
    public void setProcessing(String processing){
        this.processing = processing;
    }
    
    public String getName() {return this.name;}
    public String getType() {return this.type;}
    public String getMinimum() {return this.minimum;}
    public String getMaximum() {return this.maximum;}
    public String getLocation() {return this.location;}
    public String getAverage() {return this.average;}
    public String getHoursNumber() {return this.hoursNumber;}
    public String getValue() {return this.value;}
    public String getProcessing() {return this.processing;}
}
