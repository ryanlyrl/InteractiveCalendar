/**
 * Created by Ryan on 2017-01-04.
 */
public class ToDoTester {

    public static void main(String[] args) {
        Task a = new Task("A", "Task A", 1000);
        Task b = new Task("B", "Task B", 100);
        Task c = new Task("C", "Task C", 10);
        Task d = new Task("D", "Task D", 100);
        a.setDaysSinceAdded(1);
        b.setDaysSinceAdded(3);
        c.setDaysSinceAdded(5);
        d.setDaysSinceAdded(1);
        Task[] tasks = {a,b,c,d};
        ToDo list = new ToDo(tasks);
        list.setSortByDays(true);
        System.out.println(list);
        System.out.println("\nCalculating priorities...\n");
        list.refreshPriority();
        System.out.println(list);
        System.out.println("\nPushing task...\n");
        System.out.println("Task pushed: " + list.pushTask() + "\n");
        System.out.println(list);
    }
}
