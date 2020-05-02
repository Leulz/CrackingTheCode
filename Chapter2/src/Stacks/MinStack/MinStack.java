package Stacks.MinStack;

import Stacks.Stack;

import java.util.HashMap;

public class MinStack {
    private Stack stack;
    private Integer min;
    private HashMap<Integer, MinStackNode> previousMinMap;

    public MinStack() {
        stack = new Stack();
        previousMinMap = new HashMap<>();
    }

    public void push(int d) {
        stack.push(d);

        if (min == null || d <= min) {
            if (previousMinMap.containsKey(d)) {
                previousMinMap.get(d).times++;
            } else {
                MinStackNode msn = new MinStackNode(min);
                previousMinMap.put(d, msn);
            }
            min = d;
        }
    }

    public Integer pop() {
        Integer popped = stack.pop();

        if (popped != null && popped == min) {
            if (previousMinMap.get(popped).times > 1) {
                previousMinMap.get(popped).times--;
            } else {
                MinStackNode msn = previousMinMap.remove(popped);
                min = msn.previousMin;
            }
        }

        return popped;
    }

    public Integer min() {
        return min;
    }
}
