public class ThreadedBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;
        boolean isLeftThread;
        boolean isRightThread;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.isLeftThread = true;
            this.isRightThread = true;
        }
    }

    private Node root;

    private Node leftMost(Node node) {
        if (node == null) return null;

        while (!node.isLeftThread && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void inorder() {
        if (root == null) return;

        Node curr = leftMost(root);

        while (curr != null) {
            System.out.print(curr.data + " ");

            if (curr.isRightThread) {
                curr = curr.right;
            } else {
                curr = leftMost(curr.right);
            }
        }
        System.out.println();
    }

    public void insert(int key) {
        Node parent = null;
        Node curr = root;

        while (curr != null) {
            if (key == curr.data) {
                return;
            }
            parent = curr;

            if (key < curr.data) {
                if (!curr.isLeftThread) {
                    curr = curr.left;
                } else {
                    break;
                }
            } else {
                if (!curr.isRightThread) {
                    curr = curr.right;
                } else {
                    break;
                }
            }
        }

        Node newNode = new Node(key);

        if (parent == null) {
            root = newNode;
        } else if (key < parent.data) {
            newNode.left = parent.left;
            newNode.right = parent;
            parent.isLeftThread = false;
            parent.left = newNode;
        } else {
            newNode.left = parent;
            newNode.right = parent.right;
            parent.isRightThread = false;
            parent.right = newNode;
        }
    }

    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);

        tree.inorder();
    }
}
