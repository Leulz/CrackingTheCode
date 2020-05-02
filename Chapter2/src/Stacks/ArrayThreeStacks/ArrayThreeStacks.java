package Stacks.ArrayThreeStacks;

import java.util.HashSet;
import java.util.Set;

public class ArrayThreeStacks {
    private StackNode[] arr;
    private int currentIndex = 0;
    private int[] stackHeads = {-1, -1, -1};
    private Set<Integer> freeIndexes;

    public ArrayThreeStacks(int stackSize) {
        int arrSize = stackSize * 3;
        this.arr = new StackNode[arrSize];
        this.freeIndexes = new HashSet<>();
    }

    private int getIndex() {
        if (!freeIndexes.isEmpty()) {
            int index = freeIndexes.iterator().next();
            freeIndexes.remove(index);
            return index;
        } else {
            return currentIndex;
        }
    }

    public void push(int stackNum, int data) {
        int index = getIndex();
        int previousHead = stackHeads[stackNum];
        StackNode node = new StackNode(data, previousHead);
        stackHeads[stackNum] = index;
        arr[index] = node;

        if (index == currentIndex) {
            currentIndex++;
        }
    }

    public Integer pop(int stackNum) {
        int headIndex = stackHeads[stackNum];
        if (headIndex == -1) {
            return null;
        }

        StackNode node = arr[headIndex];
        stackHeads[stackNum] = node.previous;
        arr[headIndex] = null;

        if (headIndex == currentIndex - 1) {
            currentIndex--;
        } else {
            freeIndexes.add(headIndex);
        }

        return node.data;
    }
}
