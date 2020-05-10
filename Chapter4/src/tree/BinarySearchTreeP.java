package tree;

import tree.nodes.Node;
import tree.nodes.NodeWithParent;

public class BinarySearchTreeP extends AbstractBinarySearchTree {

    private NodeWithParent root;

    public BinarySearchTreeP() {}

    public BinarySearchTreeP(int d) {
        this.root = new NodeWithParent(d, null);
    }

    public void addNode(int d) {
        NodeWithParent n = new NodeWithParent(d);
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

        n.setParent(tmp);
    }


}
