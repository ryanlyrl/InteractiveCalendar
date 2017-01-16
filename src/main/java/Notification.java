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

    public static String pushNotification(Reminder item){
        if(item.isTime()) {
            return item.getName() + " is happening right now!";
        } else {
            return null;
        }
    }

    public static String pushNotification(Event item){
        if(item.isTime()) {
            return item.getName() + " is happening right now!";
        } else {
            return null;
        }
    }

}