package Stacks.MinStack;

public class MinStackNode {
    Integer previousMin;
    int times;

    public MinStackNode(Integer previousMin) {
        this.previousMin = previousMin;
        times = 1;
    }
}
