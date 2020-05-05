package LinkedList;

import java.util.HashMap;
import java.util.Optional;

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

    // I actually had a stupid solution originally, iterating through all nodes starting from n.
    // This was the solution suggested by the book.
    static boolean removeGivenNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }

        n.data = n.next.data;
        n.next = n.next.next;

        return true;
    }

    public static int zeroIfNull(Integer num) {
        return Optional.ofNullable(num).orElse(0);
    }

    static Node addIntegers(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }

        Node head = new Node(0);
        int headData = 0;
        int remainder;

        if (n1 != null) {
            headData += n1.data;
            n1 = n1.next;
        }

        if (n2 != null) {
            headData += n2.data;
            n2 = n2.next;
        }

        head.data = headData % 10;
        remainder = headData / 10;


        while (n1 != null && n2 != null) {
            int resultData = n1.data + n2.data + remainder;
            remainder = resultData / 10;
            head.appendToTail(resultData % 10);
            n1 = n1.next;
            n2 = n2.next;
        }

        while (n1 != null) {
            int resultData = n1.data + remainder;
            remainder = resultData / 10;
            head.appendToTail(resultData % 10);
            n1 = n1.next;
        }

        while (n2 != null) {
            int resultData = n2.data + remainder;
            remainder = resultData / 10;
            head.appendToTail(resultData % 10);
            n2 = n2.next;
        }

        return head;
    }

    public static void printNode(Node n) {
        while (n != null) {
            System.out.print(n.data);
            System.out.print(" -> ");
            n = n.next;
        }
    }

    public static Node locateCycle(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = n1.appendToTail(2);
        Node n3 = n2.appendToTail(3);
        Node n4 = n3.appendToTail(4);
        n4.next = n4;

        Node cycleBegin = locateCycle(n1);

        System.out.println(cycleBegin.data);
    }
}