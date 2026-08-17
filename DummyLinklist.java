public static Node removeElements(Node head, int target) {
    Node dummy = new Node(0);
    dummy.next = head;
    Node current = dummy;

    while (current.next != null) {
        if (current.next.val == target) {
            current.next = current.next.next; 
        } else {
            current = current.next;
        }
    }
    return dummy.next; 
}
