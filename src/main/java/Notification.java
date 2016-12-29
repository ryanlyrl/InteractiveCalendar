import java.util.Date;

/**
 * ICS4UR-Summative-V1.0, created by Ryan Ly on 12/21/2016.
 */
public class Notification {

//    private boolean isTime(Reminder reminder){
//        if(reminder.time == new Date(System.currentTimeMillis()).getTime()){
//            return true;
//        } else {
//            return false;
//        }
//    }

    private boolean isTime(Schedule schedule){
        if(schedule.isEvent || schedule.isReminder){
            if(schedule.time == new Date(System.currentTimeMillis()).getTime()){
                return true;
            } else {
                return false;
            }
        }
    }

    private double timeDifference(Schedule item){
        return ((System.currentTimeMillis() - item.time.getTime()) / (1000 * 60 * 60));
    }

//    private boolean isTime(Event event){
//        if(event.time == new Date(System.currentTimeMillis()).getTime()){
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void pushNotification(Schedule item){
        if(isTime(item)){
           popupNotification(item.getName() + " is happening right now!");
           GUINotification("Boop! It's time for " + item.getName());
        } else if(timeDifference(item) < 1){
            GUINotification(item.getName() + " is happening in " + (int)timeDifference(item) + " hours.");
        }
    }

    public void popupNotification(String message){
        //Placeholder method
        gui.popupNotification(message);
    }

    public void GUINotification(String message){
        //Placeholder method
        gui.doNotification(message);
    }

}