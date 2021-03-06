package tree;

import tree.nodes.Node;

public class BinarySearchTree extends AbstractBinarySearchTree {

    public BinarySearchTree(){super();}

    public BinarySearchTree(int d) {
        super(d);
    }

    public void addNode(int d) {
        Node n = new Node(d);
        Node currentNode = this.getRoot();
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
            this.setRoot(n);
        }
        else if (d > tmp.getData()) {
            tmp.setRight(n);
        } else {
            tmp.setLeft(n);
        }
    }
}
