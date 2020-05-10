package tree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        System.out.println("maxH is " + maxHeight);

        return IntStream.range(0, maxHeight).mapToObj(this::getNodesInLevel).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = IntStream.range(1, 20).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());

        BSTFromArray bstFromArray = new BSTFromArray(list);
        BinarySearchTree bst = bstFromArray.getBST();

        ll.Node n = bst.getNodesInLevel(4);
        if (n != null) {
            n.printLL();
        }

    }
}
