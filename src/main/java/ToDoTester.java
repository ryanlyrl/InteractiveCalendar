import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by Ryan on 2017-01-04.
 */
public class ToDoTester {

    public static void main(String[] args) {
        ToDo list = new ToDo();
        list.readFile("todo.txt");
        System.out.println(list);
        System.out.println("\nCalculating priorities...\n");
        list.refreshPriority();
        System.out.println(list);
        System.out.println("\nPushing task...\n");
        System.out.println("Task pushed: " + list.pushTask() + "\n");
        System.out.println(list);

        list.writeFile("todo.txt");
    }
}
