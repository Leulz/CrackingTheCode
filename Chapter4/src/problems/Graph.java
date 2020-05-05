package problems;

import graph.Node;

public class Graph {

    private static void canReachProblem() {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        node1.addNode(node2);
        node2.addNode(node3);
        node2.addNode(node4);
        // node1 -> node2 -> node3
        //                \
        //                -> node4
        
        System.out.println("Can node1 reach node3? " + node1.canReach(node3));
        System.out.println("Can node3 reach node1? " + node3.canReach(node1));
        System.out.println("Can node3 reach node4? " + node3.canReach(node4));
    }

    public static void main(String[] args) {
        canReachProblem();
    }
}
