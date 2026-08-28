public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public boolean deleteByValue(int value) {
        if (head == null) return false;

        if (head.data == value) {
            head = head.next;
            return true;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data != value) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtHead(5);
        list.insertAtEnd(30);

        list.printList();

        list.deleteByValue(20);
        list.printList();
    }
}
