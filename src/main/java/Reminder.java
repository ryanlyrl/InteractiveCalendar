/**
 * @(#)Reminder.java
 *
 *
 * @author 
 * @version 1.00 2016/12/16
 */


public class Reminder extends Schedule{
	
	public sDate date;

    public Reminder() {
    	super("no name");
    	this.date = new sDate();
    	
    }
    
    public Reminder(sDate d, String n){
    	super(n);
    	this.date = d;
    	
    }
    
    public String toString(){
    	return(super.toString()+"\n"+this.date);
    }
    
    
}