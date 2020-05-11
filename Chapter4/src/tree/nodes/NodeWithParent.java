package tree.nodes;

public class NodeWithParent extends Node {
    private NodeWithParent parent;

    public NodeWithParent(int data) {
        super(data);
    }

    public NodeWithParent(int data, NodeWithParent parent) {
        this(data);
        this.parent = parent;
    }

    public NodeWithParent getParent() {
        return parent;
    }

    public void setParent(NodeWithParent parent) {
        this.parent = parent;
    }
}
