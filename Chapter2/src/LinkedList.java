import java.util.HashMap;

public class LinkedList {

    Node deleteNode(Node head, int d) {
        Node n = head;
        if (n.data == d) {
            return head.next;
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return null;
    }

    static void removeDuplicates(Node head) {
        HashMap<Integer, Boolean> seen = new HashMap<>();
        Node n = head;

        while (n.next != null) {
            seen.put(n.data, true);
            if (seen.containsKey(n.next.data)) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public static void main(String[] args) {
        Node n = new Node(5);
        n.appendToTail(5);
        n.appendToTail(3);
        n.appendToTail(5);
        n.appendToTail(4);
        n.appendToTail(5);
        n.appendToTail(5);
        n.appendToTail(4);
        n.appendToTail(4);
        LinkedList.removeDuplicates(n);

        Node tmp = n;

        while (tmp != null) {
            System.out.println("---");
            System.out.println(tmp.data);
            System.out.println("---");
            tmp = tmp.next;
        }
    }
}