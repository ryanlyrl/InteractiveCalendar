/**
 * ICS4UR-Summative-V1.0, created by Ryan Ly on 12/14/2016.
 */
public class LinkedList {

     Node head;
     int length;

    public LinkedList(){
        this.head = null;
        this.length = 0;
    }

    public LinkedList(Node head){
        this.head = head;
        this.length = 1;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        } else {
            return false;
        }
    }

    public void add(Object cargo, int index){
        Node node = head;

        //Cannot add to a non existant index (i.e. can't add to index 100 of length 10 list)
        if(index > length || index < 0){
            return;
        }

        //Handles adding to the beginning of the list
        if(index == 0){
            //Sets new node's next to be previous head, then sets new node as head
            Node a = new Node(cargo, head);
            head = a;
            length++;
            return;
        }
        //Iterates to desired node
        for(int i = 0; i < index - 1;i++){
            node = node.next;
        }
        //If the node is not the last node (i.e between 1 and length)
        if(index != length){
            //Inserts the cargo into right spot, sets next to the node that was previously there
            node.next = new Node(cargo, node.next);
            length++;
            //Handles adding to end of list
        } else if(index == length){
            //Same as above, but sets next to null
            node.next = new Node(cargo, null);
            length++;
        }
    }

    public void addLast(Object cargo){
        add(cargo, length);
    }

    public void remove(int index){
        Node node = head;
        for(int i = 0;i < index - 1;i++){
            node = node.next;
        }

        node.next = node.next.next;
    }

    public int getLength(){
        return length;
    }

    public Node getHead(){
        return head;
    }

    public Node findNode(int index){
        Node node = head;
        for(int i = 0;i < index;i++){
            node = node.next;
        }

        return node;
    }

    //Takes a cargo, find and returns the index at which it is located
    public int findCargo(Object cargo){
        for(int i = 0;i < length;i++){
            if(findNode(i).cargo.equals(cargo)){
                return i;
            }
        }

        return -1;
    }

    public String toString(){
        String output = "";
        Node node = head;
        for(int i = 0;i < length;i++){
            output += node;
            node = node.next;
        }

        return output;
    }

}
