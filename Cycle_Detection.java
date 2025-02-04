// Floyd's Cycle Detection Algorithm
// O(n) Tc
// O(1) Sc

import java.util.Scanner;
public class Cycle_Detection
{
    static class Node{
        // |4|  data next 
        Node next;
        int data;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }//end of the inner class "Node"

    public static boolean hasCycle(Node head) // helper method which implements Floyd's algorithm
    {
        //Floyd's Algo to detect cycles in LL 

        // slow and fast pointers
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;//Moves 1 step at a time
            fast=fast.next.next; //Moves 2 steps at a time

            if(slow==fast) // Cycle detected
            {
                return true;
            }
        }
        return false; // No cycle found
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); // object of scanner class to take user inputs
        int size = sc.nextInt(); // asking user how many nodes are present in the LL

       if (size <= 0) 
        {
            System.out.println("Empty LL");
            return;
        }

        // size= 1 2 5......
        // size=5;

        Node head = null, tail = null;
        for (int i = 0; i < size; i++) // to fill in the data and make in connections
        {

            int value = sc.nextInt(); // taking data input 
            Node newNode = new Node(value); // newNode with value as data

            if (head == null) // means our LL was empty and this newnode is the first node of LL
            {
                head = newNode;
                tail = newNode;
            } 
            else
            {
                tail.next = newNode; // step 1 pointed tail.next new node
                tail = newNode; // step 2 -> modified our tail 
            }
        }
        // tail.next=null;

        int pos = sc.nextInt(); // cycle position 0 to size-1 | 1 to size

        if(pos>=0 && pos<=size-1)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

        
        if (pos > 0) {
            Node temp = head; // temp points to head
            Node cycleNode = null; // points to null
            int count = 1; // initial count is 1

            while (temp != null) // until we have covered complete LL from L to R
            {
                if (count == pos)
                {
                    cycleNode = temp; // if block
                }

                if (temp.next == null) // if block 2
                {
                    temp.next = cycleNode; // temp.next was null prev but now for making a loop it should point to the cycleNode or pos node
                    break;
                }

                temp = temp.next; // moves 1 step at a time 
                count++; // inc count 
            }
        }

        System.out.println((hasCycle(head) ? "true" : "false")); // ternary operator ? :
    }

}


