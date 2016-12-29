/**
 * @(#)Event.java
 *
 *
 * @author 
 * @version 1.00 2016/12/16
 */


public class Event extends Schedule{
	
	private sDate from;
	private sDate to;
	private String description;	

    public Event(sDate f, sDate t, String n) {
		super(n);
    	this.from = f;
    	this.to = t;
    	this.description = "no description";
    }
    
    public Event(){
		super("no name");
    	this.from = new sDate();
    	this.to = new sDate();
    	this.description = "no description";
    }
    
    public String toString(){
    	return (super.toString()+"\n"+this.description+"\n"+this.from+"\n"+this.to+"\n");
    }
    
    
}