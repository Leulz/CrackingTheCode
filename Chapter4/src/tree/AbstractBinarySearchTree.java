package tree;

import tree.nodes.Node;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractBinarySearchTree {

    private Node root;

    public AbstractBinarySearchTree() {}

    public AbstractBinarySearchTree(int d) {
        this.root = new Node(d);
    }

    public abstract void addNode(int d);

    private int maxHeight(Node n) {
        if (n == null) {
            return 0;
        }

        return 1 + Math.max(maxHeight(n.getLeft()), maxHeight(n.getRight()));
    }

    public int maxHeight() {
        return maxHeight(root);
    }

    private void preorder(Node n) {
        if (n != null) {
            System.out.println(n.getData());
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    public void preorder() {
        Node current = getRoot();
        preorder(current);
    }

    private int minHeight(Node n) {
        if (n == null) {
            return 0;
        }

        return 1 + Math.min(minHeight(n.getLeft()), minHeight(n.getRight()));
    }

    public int minHeight() {
        return minHeight(root);
    }

    public boolean isBalanced() {
        return Math.abs(minHeight() - maxHeight()) <= 1;
    }

    private void getNodesInLevel(ll.Node LLNode, Node node, int level) {
        if (node == null) {
            return;
        } else if (level == 0) {
            LLNode.appendToTail(node.getData());
        } else {
            getNodesInLevel(LLNode, node.getLeft(), level - 1);
            getNodesInLevel(LLNode, node.getRight(), level - 1);
        }
    }

    private ll.Node getNodesInLevel(int level) {
        ll.Node head = new ll.Node();
        getNodesInLevel(head, root, level);

        return head.next;
    }

    public List<ll.Node> getLLPerLevel() {
        int maxHeight = maxHeight();

        return IntStream.range(0, maxHeight).mapToObj(this::getNodesInLevel).collect(Collectors.toList());
    }

    public Node findNode(int d) {
        Node n = getRoot();

        while (n != null && n.getData() != d) {
            if (d > n.getData())
                n = n.getRight();
            else
                n = n.getLeft();
        }

        return n;
    }

    public Node findLeftmostNode(Node n) {
        while (n.getLeft() != null)
            n = n.getLeft();
        return n;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
