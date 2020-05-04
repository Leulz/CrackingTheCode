package stacks.SetOfStacks;

public class SOSNode {
    public SOSNode globalPrevious;
    public SOSNode localPrevious;

    public SOSNode(SOSNode globalPrevious, SOSNode localPrevious) {
        this.globalPrevious = globalPrevious;
        this.localPrevious = localPrevious;
    }
}
