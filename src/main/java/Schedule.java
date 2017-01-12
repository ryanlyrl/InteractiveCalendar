/**
 * @(#)Schedule.java
 *
 *
 * @author 
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

    public static boolean checkInput(String input){
        if(!input.contains(":")){
            return false;
        }
        int colonIndex = -1;
        for(int i = 0;i < input.length();i++){
            if(input.charAt(i) == ':'){
                colonIndex = i;
            }
        }

        try{
            int hour = Integer.parseInt(input.substring(0,colonIndex));
            int minute = Integer.parseInt(input.substring(colonIndex+1,input.length()));

            if(hour < 0 || hour >= 24 || minute < 0 || minute >= 60){
                return false;
            } else {
                return true;
            }
        } catch (Exception e){
            return false;
        }
    }
}