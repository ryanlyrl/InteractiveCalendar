/**
 * ICS4UR-Summative-V1.0, created by Ryan Ly on 12/14/2016.
 */
public class ToDo extends PriorityQueue {

    private boolean sortByDays; //True = priority based on time in list. False = based on importance only!
    public ToDo(){
        super();
    }

    public ToDo(Task task){
        super(task);
    }

    public void sort(){
        boolean done = false;
        while(!done) {
            done = true;
            for (int i = 0; i < length; i++) {
                if(((Task)findNode(i).cargo).compareTo(findNode(i+1).cargo) < 1){
                    swap(i, i+1);
                    done = false;
                }
            }
        }
    }

    private void swap(int index1,int index2){
        Node temp = findNode(index1).next;
        findNode(index1).next = findNode(index2).next;
        findNode(index2).next = temp;
    }

    private void calcPriority(Task task){
        if(sortByDays){
            task.setPriority(Math.pow(task.getImportance(),task.getDaysSinceAdded());
        } else {
            task.setPriority(task.getImportance());
        }
    }

    public Task pushTask(){
        Node node = this.head;
        while(node.next != null) {
            calcPriority((Task)node.cargo);
            node = node.next;
        }
        sort();
        Task out = (Task)head.cargo;
        remove(0);
        return out;
    }

}
