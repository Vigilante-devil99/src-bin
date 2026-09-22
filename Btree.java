public class BTree {

    private static final int T = 2; 

    static class Node {
        int[] keys = new int[2 * T - 1];
        Node[] children = new Node[2 * T];
        int numKeys = 0;
        boolean isLeaf;

        Node(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        void traverse() {
            int i;
            for (i = 0; i < numKeys; i++) {
                if (!isLeaf) {
                    children[i].traverse();
                }
                System.out.print(keys[i] + " ");
            }
            if (!isLeaf) {
                children[i].traverse();
            }
        }
    }

    private Node root;

    public BTree() {
        this.root = new Node(true);
    }

    public void traverse() {
        if (root != null) {
            root.traverse();
            System.out.println();
        }
    }

    public void insert(int key) {
        Node r = root;

        if (r.numKeys == 2 * T - 1) {
            Node s = new Node(false);
            root = s;
            s.children[0] = r;
            splitChild(s, 0, r);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(Node node, int key) {
        int i = node.numKeys - 1;

        if (node.isLeaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.numKeys++;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }
            i++;

            if (node.children[i].numKeys == 2 * T - 1) {
                splitChild(node, i, node.children[i]);
                if (key > node.keys[i]) {
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(Node parent, int i, Node child) {
        Node sibling = new Node(child.isLeaf);
        sibling.numKeys = T - 1;

        for (int j = 0; j < T - 1; j++) {
            sibling.keys[j] = child.keys[j + T];
        }

        if (!child.isLeaf) {
            for (int j = 0; j < T; j++) {
                sibling.children[j] = child.children[j + T];
            }
        }

        child.numKeys = T - 1;

        for (int j = parent.numKeys; j >= i + 1; j--) {
            parent.children[j + 1] = parent.children[j];
        }
        parent.children[i + 1] = sibling;

        for (int j = parent.numKeys - 1; j >= i; j--) {
            parent.keys[j + 1] = parent.keys[j];
        }
        parent.keys[i] = child.keys[T - 1];
        parent.numKeys++;
    }

    public static void main(String[] args) {
        BTree tree = new BTree();

        int[] values = {10, 20, 5, 6, 12, 30, 7, 17};
        for (int v : values) {
            tree.insert(v);
        }

        tree.traverse();
    }
}
