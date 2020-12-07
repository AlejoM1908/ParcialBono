//Java imports
package lib.models;

public class SendModel{
    private final String name;
    private final String type;
    private final double minimum;
    private final double maximum;
    private final String location;
    private final double average;
    private final int hoursNumber;
    private final double value;
    private final String dateTime;
    private final String processing;

    public SendModel(String name,String type,double minimum,double maximum,String location,double average,int hoursNumber,
            double value,String dateTime,String processing){
        this.name = name;
        this.type = type;
        this.minimum = minimum;
        this.maximum = maximum;
        this.location = location;
        this.average = average;
        this.hoursNumber = hoursNumber;
        this.value = value;
        this.dateTime = dateTime;
        this.processing = processing;
    }

    public String getName() {return this.name;}
    public String getType() {return this.type;}
    public double getMinimum() {return this.minimum;}
    public double getMaximum() {return this.maximum;}
    public String getLocation() {return this.location;}
    public double getAverage() {return this.average;}
    public int getHoursNumber() {return this.hoursNumber;}
    public double getValue() {return this.value;}
    public String getDateTime() {return this.dateTime;}
    public String getProcessing() {return this.processing;}
}