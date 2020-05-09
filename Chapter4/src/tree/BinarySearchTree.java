package tree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {}

    public BinarySearchTree(int d) {
        this.root = new Node(d);
    }

    public void addNode(int d) {
        Node n = new Node(d);
        Node currentNode = root;
        Node tmp = null;

        while (currentNode != null) {
            tmp = currentNode;

            if (d > currentNode.getData()) {
                currentNode = currentNode.getRight();
            } else {
                currentNode = currentNode.getLeft();
            }
        }

        if (tmp == null) {
            root = n;
        }
        else if (d > tmp.getData()) {
            tmp.setRight(n);
        } else {
            tmp.setLeft(n);
        }
    }

    private int maxHeight(Node n) {
        if (n == null) {
            return 0;
        }

        return 1 + Math.max(maxHeight(n.getLeft()), maxHeight(n.getRight()));
    }

    public int maxHeight() {
        return maxHeight(root);
    }

    private int minHeight(Node n) {
        if (n == null) {
            return 0;
        }

        return 1 + Math.min(minHeight(n.getLeft()), minHeight(n.getRight()));
    }

    private void preorder(Node n) {
        if (n != null) {
            System.out.println(n.getData());
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    public void preorder() {
        Node current = root;
        preorder(current);
    }

    public int minHeight() {
        return minHeight(root);
    }

    public boolean isBalanced() {
        return Math.abs(minHeight() - maxHeight()) <= 1;
    }
}
