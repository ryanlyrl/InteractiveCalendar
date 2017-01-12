import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * ICS4UR-Summative-V1.0, created by Ryan Ly on 12/16/2016.
 */
public class Task extends Schedule implements Comparable {

    private int priority;
    private int importance;
    private int daysSinceAdded;
    private sDate dateAdded;

    //Default constructor
    public Task(){
        super();
        this.importance = -1;
        this.daysSinceAdded = -1;
        this.dateAdded = new sDate();
    }
    //Constructor for creating a new task
    public Task(String name, int importance){
        super(name);
        this.importance = importance;
        this.daysSinceAdded = 0;
        this.dateAdded = sDate.now();
    }
    //Constructor for importing an existing class
    public Task(String name, int importance, int daysSinceAdded){
        super(name);
        this.importance = importance;
        this.daysSinceAdded = daysSinceAdded;
    }
    //Contructor taking an sDate, automatically converts to daysSinceAdded
    public Task(String name, int importance, sDate dateAdded){
        super(name);
        this.importance = importance;
        this.dateAdded = dateAdded;

        Period period = Period.between(sDate.convertToLocalDateTime(dateAdded).toLocalDate(), LocalDate.now());
        this.daysSinceAdded = period.getDays();
    }
    //Compares two tasks (implements Comparable)
    public int compareTo(Object obj){
        Task other = (Task)obj;

        return this.priority - other.priority;
    }
    //Accessor and mutator methods
    public void setPriority(int input){
        this.priority = input;
    }

    public int getImportance(){
        return this.importance;
    }

    public int getPriority(){ return this.priority; }

    public sDate getDateAdded(){ return this.dateAdded; }

    public int getDaysSinceAdded(){
        return this.daysSinceAdded;
    }

    public void setDaysSinceAdded(int days) {
        this.daysSinceAdded = days;
    }

    //ToString in format: "TasK: {name} Priority: {priority}
    public String toString(){
        return "Task: " + this.getName() + "\nPriority: " + priority + "\n";
    }

}
