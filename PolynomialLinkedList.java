class Node {
    int coeff;
    int exp;
    Node next;

    Node(int coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
        this.next = null;
    }
}

public class PolynomialLinkedList {

    public static Node insert(Node head, int coeff, int exp) {
        Node newNode = new Node(coeff, exp);

        if (head == null || exp > head.exp) {
            newNode.next = head;
            return newNode;
        }

        Node curr = head;
        while (curr.next != null && curr.next.exp >= exp) {
            curr = curr.next;
        }

        if (curr.exp == exp) {
            curr.coeff += coeff;
        } else {
            newNode.next = curr.next;
            curr.next = newNode;
        }

        return head;
    }

    public static Node add(Node p1, Node p2) {
        Node dummy = new Node(0, 0);
        Node curr = dummy;

        while (p1 != null && p2 != null) {
            if (p1.exp > p2.exp) {
                curr.next = new Node(p1.coeff, p1.exp);
                p1 = p1.next;
            } else if (p1.exp < p2.exp) {
                curr.next = new Node(p2.coeff, p2.exp);
                p2 = p2.next;
            } else {
                int sumCoeff = p1.coeff + p2.coeff;
                if (sumCoeff != 0) {
                    curr.next = new Node(sumCoeff, p1.exp);
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            if (curr.next != null) {
                curr = curr.next;
            }
        }

        while (p1 != null) {
            curr.next = new Node(p1.coeff, p1.exp);
            curr = curr.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            curr.next = new Node(p2.coeff, p2.exp);
            curr = curr.next;
            p2 = p2.next;
        }

        return dummy.next;
    }

    public static Node multiply(Node p1, Node p2) {
        Node result = null;

        for (Node ptr1 = p1; ptr1 != null; ptr1 = ptr1.next) {
            for (Node ptr2 = p2; ptr2 != null; ptr2 = ptr2.next) {
                int coeff = ptr1.coeff * ptr2.coeff;
                int exp = ptr1.exp + ptr2.exp;
                result = insert(result, coeff, exp);
            }
        }
        return result;
    }

    public static void display(Node head) {
        if (head == null) {
            System.out.println("0");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.coeff + "x^" + curr.exp);
            curr = curr.next;
            if (curr != null && curr.coeff >= 0) {
                System.out.print(" + ");
            } else if (curr != null) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node p1 = null;
        p1 = insert(p1, 5, 2);
        p1 = insert(p1, 4, 1);
        p1 = insert(p1, 2, 0);

        Node p2 = null;
        p2 = insert(p2, 3, 3);
        p2 = insert(p2, 2, 2);
        p2 = insert(p2, 1, 0);

        System.out.print("P1: ");
        display(p1);

        System.out.print("P2: ");
        display(p2);

        Node sum = add(p1, p2);
        System.out.print("Sum: ");
        display(sum);

        Node product = multiply(p1, p2);
        System.out.print("Product: ");
        display(product);
    }
}
