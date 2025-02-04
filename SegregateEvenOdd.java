//Segregate Even & Odd Nodes in a Linked List

// Input: 17->15->8->12->10->5->4->1->7->6->NULL
// Output: 8->12->10->4->6->17->15->5->1->7->NULL

import java.util.Scanner;

public class SegregateEvenOdd {

    static class Node {
        // |4| data next
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }// end of the inner class "Node"

    public static Node segregateEvenOdd(Node head) {
        // Input: 17->15->8->12->10->5->4->1->7->6->NULL
        // head is 17

        if(head==null || head.next==null)
        {
            return head;
        }

        Node evenStart=null,oddStart=null,evenEnd=null,oddEnd=null;

        Node temp=head;

        while(temp!=null) // Traversing the LL
        {
            Node curr=temp;
            int value=curr.data;

            if(value%2==0) // even value
            {
                if(evenStart==null) // Even LL was empty
                {
                    evenStart=curr;
                    evenEnd=curr;
                }
                else
                {
                    evenEnd.next=curr;
                    evenEnd=evenEnd.next;
                }
            }
            else{ // odd value

                if(oddStart==null) // Even LL was empty
                {
                    oddStart=curr;
                    oddEnd=curr;
                }
                else
                {
                    oddEnd.next=curr;
                    oddEnd=oddEnd.next;
                }
            }

            temp=temp.next; // one step at a time 

        }// end of while

        if(evenStart==null) // no even value was found
        {
            return oddStart;
        }
        if(oddStart==null) // no odd value was found
        {
            return evenStart;
        }
        // if both LL exists even + odd

        oddEnd.next=null;
        evenEnd.next=oddStart;

        return evenStart; // result

    }

    public static void printList(Node head) {
        // print the values of LL

        Node temp=head;

        while (temp!=null) {
            int value=temp.data;
            System.out.print(value+" -> ");

            temp=temp.next;
        }
        System.out.print(" null ");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); // size of LL -> how many elements

        if (size <= 0) {
            System.out.println("Empty LL");
        }

        Node head = null, tail = null;

        for (int i = 0; i < size; i++) {
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node ans = segregateEvenOdd(head);
        printList(ans);
    }
}
