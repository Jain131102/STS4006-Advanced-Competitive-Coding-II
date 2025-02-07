import java.util.Scanner;

public class MergeSortDLL {
    static class Node {
        Node next, prev;
        int data;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    // Merge two sorted doubly linked lists
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

        ans=ans.next;
        ans.prev=null;
        return ans;
    }

    // Find the middle of the list
    static Node mid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Perform merge sort on the list
    static Node mergeSort(Node head) {
        // Base case: if head is null or there's only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list
        Node middle = mid(head);
        Node right = middle.next;
        middle.next = null;

        // Recursively sort both halves
        Node left = mergeSort(head);
        right = mergeSort(right);

        // Merge sorted halves
        return merge(left, right);
    }

    // Print list contents
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements (n): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("List is empty.");
            sc.close();
            return;
        }

        System.out.println("Enter elements of the list:");
        Node dummy = new Node(-1);
        Node tail = dummy;

        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            Node node = new Node(e);
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }

        Node head = dummy.next;
        if (head != null) {
            head.prev = null; // Properly set the head's previous pointer
        }

        sc.close();

        System.out.println("Original list:");
        printList(head);

        // Sort the list
        head = mergeSort(head);

        System.out.println("Sorted list:");
        printList(head);
    }
}
