package tree.nodes;

public class NodeWithParent extends Node {
    private Node parent;

    public NodeWithParent(int data) {
        super(data);
    }

    public NodeWithParent(int data, Node parent) {
        this(data);
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
