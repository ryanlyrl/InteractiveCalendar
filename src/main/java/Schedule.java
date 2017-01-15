/**
 * Schedule.java - parent class for events on the calendar
 *
 *
 * @author Stephanie Wang and Ryan Ly
 * @version 1.00 2016/12/16
 */

public abstract class Schedule {
	
	private String name;

    public Schedule(String n) {
    	this.name = n;
    }

    //Default constructor
    public Schedule(){
    	this.name = "unknown";
    }

    //ToString in format: "Name"
    public String toString(){
    	return this.name + "\n";
    }

    public String getName(){
        return this.name;
    }
}