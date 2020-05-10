package ll;

public class Node {
    public Node next = null;
    public int data;

    public Node() {}

    public Node(int d) { data = d; }

    public Node appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
        return end;
    }

    public void printLL() {
        Node n = this;
        while (n != null) {
            System.out.print(n.data);
            System.out.print(" -> ");
            n = n.next;
        }
        System.out.println("null");
    }
}