package stacks.SetOfStacks;

import stacks.CapacityStack;
import stacks.StackNode;

import java.util.ArrayList;

public class SetOfStacks {
    public ArrayList<CapacityStack> setOfStacks;
    public int capacity;

    public SetOfStacks(int capacity) {
        setOfStacks = new ArrayList<>();
        setOfStacks.add(new CapacityStack(capacity));
        this.capacity = capacity;
    }

    public void push(int d) {
        if (!setOfStacks.isEmpty()) {
            CapacityStack lastStack = setOfStacks.get(setOfStacks.size() - 1);
            try {
                lastStack.push(d);
            } catch (Exception e) {
                CapacityStack newStack = new CapacityStack(capacity, d);
                setOfStacks.add(newStack);
            }
        } else {
            CapacityStack newStack = new CapacityStack(capacity, d);
            setOfStacks.add(newStack);
        }
    }

    public Integer pop() {
        if (!setOfStacks.isEmpty()) {
            CapacityStack lastStack = setOfStacks.get(setOfStacks.size() - 1);
            int popped = lastStack.pop();
            if (lastStack.currentSize == 0) {
                setOfStacks.remove(setOfStacks.size() - 1);
            }
            return popped;
        } else {
            return null;
        }
    }

    // TODO popAt
}
