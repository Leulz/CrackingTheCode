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
        NodeWithParent currentNode = this.getRoot();
        NodeWithParent tmp = null;

        while (currentNode != null) {
            tmp = currentNode;

            if (d > currentNode.getData()) {
                currentNode = (NodeWithParent) currentNode.getRight();
            } else {
                currentNode = (NodeWithParent) currentNode.getLeft();
            }
        }

        if (tmp == null) {
            this.setRoot(n);
        } else if (d > tmp.getData()) {
            tmp.setRight(n);
        } else {
            tmp.setLeft(n);
        }

//        System.out.println("Root is now " + this.getRoot().getData());
//        System.out.println("n is " + n.getData());

        n.setParent(tmp);
    }

    public Node findNextNode(NodeWithParent n) {
        if (n == null)
            return null;

        if (n.getRight() != null)
            return findLeftmostNode(n.getRight());

        NodeWithParent parent = (NodeWithParent) n.getParent();

        while (parent != null && (n == parent.getRight() || parent.getRight() == null)) {
            n = parent;
            parent = (NodeWithParent) parent.getParent();
        }

        if (parent == null)
            return null;
        else
            return parent;

    }

    @Override
    public NodeWithParent getRoot() {
        return this.root;
    }

    public void setRoot(NodeWithParent n) {
        this.root = n;
    }
}
