/**
 * Notification.java - used to push notifications for events
 *
 * @author Ryan Ly
 * @version 1.00 2016/12/21
 */

import java.time.Duration;
import java.time.LocalDateTime;

public class Notification {

    private double timeDifference(Reminder item){
        return Duration.between(LocalDateTime.now(), sDate.convertToLocalDateTime(item.date)).getSeconds();
    }

    private double timeDifference(Event item){
        return Duration.between(LocalDateTime.now(), sDate.convertToLocalDateTime(item.getFrom())).getSeconds();
    }

    public void pushNotification(Reminder item){
        if(item.isTime()){
           popupNotification(item.getName() + " is happening right now!");
           GUINotification("Boop! It's time for " + item.getName());
        } else if(timeDifference(item) < 1){
            GUINotification(item.getName() + " is happening in " + (int)timeDifference(item) + " hours.");
        }
    }

    public void pushNotification(Event item){
        if(item.isTime()){
            popupNotification(item.getName() + " is happening right now!");
            GUINotification("Boop! It's time for " + item.getName());
        } else if(timeDifference(item) < 1){
            GUINotification(item.getName() + " is happening in " + (int)timeDifference(item) + " hours.");
        }
    }

    public void popupNotification(String message){
        //Placeholder method
        //gui.popupNotification(message);
    }

    public void GUINotification(String message){
        //Placeholder method
        //gui.doNotification(message);
    }

}