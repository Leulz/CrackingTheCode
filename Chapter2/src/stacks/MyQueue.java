package stacks;

import LinkedList.Node;

public class MyQueue {
    Stack stack1;
    Stack stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int d) {
        stack1.push(d);
    }

    public Integer pop() {
        if (stack2.peek() != null) {
            return stack2.pop();
        } else {
            while (true) {
                Integer popped = stack1.pop();
                if (popped == null) {
                    break;
                }
                stack2.push(popped);
            }
            return stack2.pop();
        }
    }
}
