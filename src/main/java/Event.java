import java.time.*;

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

    public Event(sDate f, sDate t, String n) {
		super(n);
    	this.from = f;
    	this.to = t;
    }

    //Constructor taking an Event from Google API
    public Event(com.google.api.services.calendar.model.Event event){
    	super(event.getId());
    	this.from = sDate.convertTosDate(event.getStart().getDateTime());
    	this.to = sDate.convertTosDate(event.getEnd().getDateTime());
	}

	///Default constructor
    public Event(){
		super("no name");
    	this.from = new sDate();
    	this.to = new sDate();
    }

    public sDate getFrom(){
		return this.from;
	}

	//Compares to current time
	public boolean isTime(){
		if(sDate.localDatesEqual(LocalDateTime.now(),sDate.convertToLocalDateTime(this.from))){
			return true;
		} else {
			return false;
		}
	}

	//ToString in format: "$name \n $from \m $to
    public String toString(){
    	return (super.toString()+"\n"+this.from+"\n"+this.to+"\n");
    }
    
    
}