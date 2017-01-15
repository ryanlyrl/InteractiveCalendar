/**
 * ToDo.java - uses PriorityQueue in order to hold tasks into a todo list
 *
 * @author Ryan Ly
 * @version 1.00 2016/12/14
 */

import java.io.*;
import java.util.Scanner;

public class ToDo extends PriorityQueue {

    private boolean sortByDays; //True = priority based on time in list. False = based on importance only!

    public ToDo(){
        super();
    }

    public ToDo(Task task){
        super(task);
    }

    //Creates a list with tasks from array
    public ToDo(Task[] task) {
        super(task[0]);
        for (int i = 1; i < task.length; i++) {
            addLast(task[i]);
        }
    }

    //Sorts the ToDo list
    public void sort(){
        Object[] tasks = new Object[this.length];
        for(int i = 0;i < this.length;i++){
            tasks[i] = findNode(i).cargo;
        }
        Heap heap = new Heap(tasks);
        heap.sort();

        int originalLength = length;
        for(int i = 0;i < originalLength;i++){
            remove(0);
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

    public void readFile(String file){
        try{
            Scanner in = new Scanner(new FileReader(file));
            while(true){
                String line = in.nextLine();
                if(!line.equals("end")){
                    this.addLast(new Task(line, Integer.parseInt(in.nextLine()), sDate.parseString(in.nextLine())));
                } else {
                    break;
                }
            }
            refreshPriority();
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }

    public void writeFile(String file){
        try{
            PrintWriter out = new PrintWriter(new FileWriter(file));
            for(int i = 0;i < length;i++){
                out.println(((Task)this.findNode(i).cargo).getName());
                out.println(((Task)this.findNode(i).cargo).getImportance());
                out.println(((Task)this.findNode(i).cargo).getDateAdded());
            }
            out.println("end");
            out.close();
        } catch (IOException e){
            System.out.println("Error writing to file.");
        }
    }
}
