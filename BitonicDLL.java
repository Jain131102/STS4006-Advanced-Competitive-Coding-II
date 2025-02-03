import java.util.Scanner;

public class BitonicDLL {

    static class Node {
        Node next, prev;
        int data;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    static Node revList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node revNode = revList(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;

        return revNode;
    }

    static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node ans = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                dummy.next = head1;
                head1.prev = dummy;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2.prev = dummy;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        while (head1 != null) {
            dummy.next = head1;
            head1.prev = dummy;
            head1 = head1.next;
            dummy = dummy.next;
        }
        while (head2 != null) {
            dummy.next = head2;
            head2.prev = dummy;
            head2 = head2.next;
            dummy = dummy.next;
        }

        return ans.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();

        Node s = new Node(-1);
        Node d = s;
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            Node node = new Node(e);
            s.next = node;
            node.prev = s; // Set previous pointer
            s = s.next;
        }

        sc.close();

        Node head1 = d.next;
        Node t = head1;

        // Bitonic -> 1 2 3 4 5 - 8 7 6

        Node first = null, second = null;
        
        // Handle edge case where no split is found
        boolean isBitonic = false;

        while (t != null && t.next != null) {
            first = t;
            second = t.next;

            if (first.data > second.data) {
                isBitonic = true;
                break;
            }

            t = t.next;
        }

        if (!isBitonic) {
            System.out.println("List is already sorted.");
            printList(head1);
            return;
        }

        first.next = null;
        second.prev = null;

        Node head2 = revList(second);

        Node ansNode = merge(head1, head2);
        printList(ansNode);

    }
}
