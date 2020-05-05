package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Node {
    private ArrayList<Node> connectedNodes;

    public Node() {
        this.connectedNodes = new ArrayList<>();
    }

    public void addNode(Node n) {
        this.connectedNodes.add(n);
    }

    public boolean canReach(Node n) {
        Stack<Node> visitedNodes = new Stack<>();
        visitedNodes.push(this);

        while (!visitedNodes.isEmpty()) {
            Node currentNode = visitedNodes.pop();
            if (currentNode == n) {
                return true;
            }

            for (Node visited : currentNode.getConnectedNodes()) {
                visitedNodes.push(visited);
            }
        }

        return false;
    }

    public ArrayList<Node> getConnectedNodes() {
        return connectedNodes;
    }
}
