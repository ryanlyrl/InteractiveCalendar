/**
 * Node.java - Object held by Linked List
 *
 * @author Ryan Ly
 * @version 1.00 2016/12/14
 */

public class Node {

    Object cargo;
    Node next;

    public Node(){
        this.cargo = null;
        this.next = null;
    }

    public Node(Object cargo, Node next){
        this.cargo = cargo;
        this.next = next;
    }

    @Override
    public String toString(){
        return cargo.toString();
    }

}
