package stacks;

import LinkedList.Node;

public class CapacityStack {
    private Node top;
    private int capacity;
    public int currentSize;

    public CapacityStack(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be positive.");
        }
        this.capacity = capacity;
    }

    public CapacityStack(int capacity, int d) throws IllegalArgumentException {
        this(capacity);
        top = new Node(d);
    }

    public void push(int d) throws Exception{
        if (this.currentSize > this.capacity) {
            throw new Exception("Cannot push, stack already with maximum capacity.");
        }

        Node newTop = new Node(d);
        newTop.next = top;
        top = newTop;
        this.currentSize++;
    }

    public Integer pop() {
        if (top == null) {
            return null;
        }

        int popped = top.data;
        top = top.next;
        this.currentSize--;
        return popped;
    }
}
