public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList L1 = new MyLinkedList();
        L1.insertAtLast(222);
        L1.insertAtLast(11);
        L1.insertAtLast(5);
        L1.insertAtLast(77);
        
        System.out.print("The original List: ");
        L1.print();
        //222   11      5       77
        //0     1       2       3
        L1.insert(7, 3);
        
        System.out.print("The List after adding 7 is: ");
        L1.print();
    }
}

class Node {

    private Object data;  //private??
    public Node next;  //public??

    public Node(Object newData) {
        data = newData;
        next = null;
    }

    public Object getData() {
        return data;
    }
}

class MyLinkedList {

    private Node head = null;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insertAtFront(Object data) {
        Node newNode = new Node(data);

        if (head == null) //case of empty list
        {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void removeAtFront() {
        if (head == null) {
            System.out.println("The list is empty!");
        } else {
            head = head.next;
        }
    }

    public void print() {
        Node current;
        current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public int size() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public Object secondElement(){
        if (this.getHead() == null || this.getHead().next == null)
            return null;
        return this.getHead().next.getData();
    }
    
    public Object lastElement(){
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        return current.getData();
    }
    
    public void insertAtLast(Object data){
        Node newNode = new Node(data);
        
        Node current = head;
        
        if(head == null)
            head = newNode;
        else{
            while(current.next != null){
                current = current.next;
            }

            current.next = newNode;
        }
    }
    
    public void removeAtLast(){
        if (head == null)
            System.out.println("The list is already empty");
        else if(head.next == null){
            System.out.println("The list is now empty");
            head = null;
        }
        else{
            Node current = head; 
            while(current.next.next != null)
                current = current.next;
            
            current.next = null;
        }
        
    }
    
    public void insert(Object data, int pos){
        if(pos < 0 || pos > this.size())
            System.out.println("Invalid Location");
        else if(pos == 0)
            this.insertAtFront(data);
        else if(pos == this.size())
            this.insertAtLast(data);
        else if(head == null)
            head = new Node(data);
        else{
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < pos -1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
}
