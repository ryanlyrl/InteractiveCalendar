import java.time.LocalDateTime;

/**
 * @(#)Date.java
 *
 *
 * @author 
 * @version 1.00 2016/12/13
 */


public class sDate {
	
	int year;
	int month;
	int day;
	int hrs;
	int min;
	//declr\are array for months
	//String mon [];

    public sDate() {
    	this.year = 2017;
    	this.month = 01;
    	this.day = 01;
    	this.hrs = 00;
    	this.min = 00;
    	
    }
    
    public sDate(int y, int m, int d, int h, int mi){
    	
    	if(m<1||m>12||d<1||d>31){
    		System.out.println ("Error: month and date invalid");
    	}
    	else{
    		this.year = y;
    		this.month = m;
    		this.day = d;
    		this.hrs = h;
    		this.min = mi;
    	}
    	
    }
    
    public String getMName(int m){
    	String [] months = {"Empty", "Jan", "Feb", "March", "Apr", "May", "June", "July", "August", "Sep", "October", "Nov", "Dec"};
    	String temp = "";
    	temp = months[m];
    	return temp;
    }
    
    public String toString(){
    	//if less than 10, add 0 to month and day
    	String month1 = getMName(this.month);
    	if(this.day < 10){
    		return (month1 + " 0" + this.day +"," + this.year + " "+this.hrs+":" + this.min);
    	}
    	else{
    		return (month1 + " " + this.day +"," + this.year + " "+this.hrs+":" + this.min);
    	}
    	
    }
    
    public int getYear(){
    	return this.year;
    }
    
    public int getMonth(){
    	return this.month;
    }
    
    public int getDay(){
    	return this.day;
    }
    
    public int getHours(){
    	return this.hrs;
    }    
    
    public int getMinutes(){
    	return this.min;
    }
    
    public void setDay(int d){
    	this.day = d;
    }
    
    public void setYear(int y){
    	this.year = y;
    }
    
    public void setMonth(int m){
    	this.month = m;
    }
    
    public void setTime(int h, int m){
    	this.hrs = h;
    	this.min = m;
    }

    public static LocalDateTime convertToLocalDateTime(sDate date){
		return LocalDateTime.now().withYear(date.year).withMonth(date.month).withDayOfMonth(date.day).withHour(date.hrs).withMinute(date.min);
	}

	//Used in place of equals in LocalDateTime (cannot override the original due to LocalDateTime being a final class, and this is simpler than making a wrapper class)
	public static boolean localDatesEqual(LocalDateTime dateOne, LocalDateTime dateTwo){
		if(dateOne.getYear() == dateTwo.getYear() && dateOne.getMonth() == dateTwo.getMonth() && dateOne.getDayOfMonth() == dateTwo.getDayOfMonth() && dateOne.getHour() == dateTwo.getHour()){
			return true;
		} else {
			return false;
		}
	}
}