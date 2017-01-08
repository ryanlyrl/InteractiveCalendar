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

    public ToDo(Task[] task){
        super(task[0]);
        for(int i = 1;i < task.length;i++){
            addLast(task[i]);
        }
    }

    /*public void sort(){
        boolean done = false;
        while(!done) {
            done = true;
            for (int i = 0; i < length - 1; i++) {
                if(((Task)findNode(i).cargo).compareTo(findNode(i+1).cargo) < 0){
                    swap(i, i+1);
                    done = false;
                }
            }
        }
    }*/

    public void sort(){
        Object[] tasks = new Object[this.length];
        for(int i = 0;i < this.length;i++){
            tasks[i] = findNode(i).cargo;
        }
        Heap heap = new Heap(tasks);
        heap.sort();
        for(int i = 0;i < length;i++){
            remove(i);
        }
        for(int i = 0; i < heap.getSize();i++){
            add(heap.getCargo(i), i);
        }
    }

    private void swap(int index1,int index2){
        Node first = findNode(index1);
        Node second = findNode(index2);
        if(second.next == null) {
            first.next = null;
        } else {
            first.next = second.next;
        }
        second.next = first;

        if(index1 == 0) {
            head = second;
        } else {
            findNode(index1 - 1).next = second;
        }
    }

    private void calcPriority(Task task){
        if(sortByDays){
            task.setPriority((int)(Math.pow(task.getImportance(),task.getDaysSinceAdded()/4.0)));
        } else {
            task.setPriority(task.getImportance());
        }
    }

    public void refreshPriority(){
            for(int i = 0;i < this.length;i++){
                calcPriority((Task)findNode(i).cargo);
        }
    }

    //Removes a completed task from the ToDo list
    public void completed(Task task){
        int cargoIndex = findCargo(task);
        if(cargoIndex != -1){
            remove(cargoIndex);
            System.out.println("Congrats! You finished " + task);
        } else {
            System.out.println("Task not found.");
        }
    }

    public Task pushTask(){
        refreshPriority();
        sort();
        Task out = (Task)head.cargo;
        this.remove(0);
        return out;
    }

    public void setSortByDays(boolean sortDays){
        sortByDays = sortDays;
    }

}
