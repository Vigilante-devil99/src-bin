public static Node sortedInsert(Node head, int val) {
    Node newNode = new Node(val);

    if (head == null) return newNode;

   
    if (val <= head.data) {
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

   
    Node curr = head;
    while (curr.next != null && curr.next.data < val) {
        curr = curr.next;
    }

    newNode.next = curr.next;
    newNode.prev = curr;
    if (curr.next != null) {
        curr.next.prev = newNode;
    }
    curr.next = newNode;

    return head;
}
