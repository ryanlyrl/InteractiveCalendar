/**
 * @(#)Schedule.java
 *
 *
 * @author 
 * @version 1.00 2016/12/16
 */

public abstract class Schedule {
	
	private String name;
	//Notification notification;

    public Schedule(String n) {
    	this.name = n;
    }

    public Schedule(){
    	this.name = "unknown";
    }

    public String toString(){
    	return this.name + "\n";
    }

    public String getName(){
        return this.name;
    }
}