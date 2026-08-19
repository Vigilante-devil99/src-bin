public class DoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    
    public void insertAfter(int target, int data) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) return; 

        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }


    public void deleteHead() {
        if (head == null) return;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    
    public void deleteTail() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    
    public void deleteByValue(int key) {
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null) return; // Value not found

        if (temp == head) {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
        
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

          
            current = current.prev;
        }

        
        if (temp != null) {
            head = temp.prev;
        }
    }

    
    public void displayForward() {
        Node temp = head;
        System.out.print("Forward:  null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    
    public void displayBackward() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.print("Backward: null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

       
        dll.insertAtHead(20);
        dll.insertAtHead(10);
        dll.insertAtTail(30);
        dll.insertAtTail(40);
        dll.insertAfter(20, 25);
        dll.displayForward();  

       
        dll.deleteHead();     
        dll.deleteTail();      
        dll.deleteByValue(25); 
        dll.displayForward();  

        
        System.out.println("Search 20: " + dll.search(20)); 
        System.out.println("Search 99: " + dll.search(99)); 

        
        dll.reverse();
        dll.displayForward();  
        dll.displayBackward(); 
    }
}
