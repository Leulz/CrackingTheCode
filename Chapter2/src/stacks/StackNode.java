package stacks;

public class StackNode {
    public int previous;
    public int data;

    public StackNode(int data, int previous) {
        this.data = data;
        this.previous = previous;
    }
}
