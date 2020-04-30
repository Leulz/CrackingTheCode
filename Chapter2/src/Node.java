public class Node {
    Node next = null;
    int data;

    public Node() {}

    public Node(int d) { data = d; }

    Node appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
        return end;
    }
}