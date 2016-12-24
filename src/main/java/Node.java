/**
 * ICS4UR-Summative-V1.0, created by Ryan Ly on 12/14/2016.
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
