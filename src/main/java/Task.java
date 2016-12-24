/**
 * ICS4UR-Summative-V1.0, created by Ryan Ly on 12/16/2016.
 */
public class Task extends Schedule implements Comparable {

    private boolean complete;
    private String description;
    private int priority;
    private int importance;
    private int daysSinceAdded;

    public Task(){
        super();
        this.description = "No description.";
        this.complete = false;
        this.priority = -1;
    }

    public Task(String name, String desc, int priority){
        super(name);
        this.description = desc;
        this.complete = false;
        this.priority = priority;
    }

    public int compareTo(Object obj){
        Task other = (Task)obj;

        return this.priority - other.priority;
    }

    public String getName(){
        return this.name;
    }

    public void setPriority(int input){
        this.priority = input;
    }

    public int getImportance(){
        return this.importance;
    }

    public int getDaysSinceAdded(){
        return this.daysSinceAdded;0
    }


    public String toString(){
        return "TasK: " + this.name + "\n" + description + "\nPriority: " + priority;
    }

}
