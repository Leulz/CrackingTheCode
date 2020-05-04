package stacks;

import LinkedList.Node;

public class Stack {
    private Node top;

    public Stack() {}

    public Stack(int d) {
        top = new Node(d);
    }

    public void push(int d) {
        Node newTop = new Node(d);
        newTop.next = top;
        top = newTop;
    }

    public Integer pop() {
        if (top == null) {
            return null;
        }

        int popped = top.data;
        top = top.next;
        return popped;
    }
}
