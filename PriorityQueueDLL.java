import java.util.Scanner;

public class PriorityQueueDLL
{
    static class Node 
    {
        int data;
        int priority;
        Node next, prev;
        Node(int data, int priority) 
        {
            this.data = data;
            this.priority = priority;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    public void insert(int data, int priority) 
    {
        Node newNode = new Node(data, priority);
        if (head == null) 
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp != null && temp.priority >= priority) 
        {
            temp = temp.next;
        }
        if (temp == null) 
        {
            Node tail = head;
            while (tail.next != null) 
            {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.prev = tail;
        } 
        else if (temp == head) 
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } 
        else 
        {
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev.next = newNode;
            temp.prev = newNode;
        }
    }

    public int remove() 
    {
        if (head == null) 
        {
            return -1;
        }
        int value = head.data;
        head = head.next;
        if (head != null) 
        {
            head.prev = null;
        }
        return value;
    }
    public void display() 
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print("(" + temp.data + ", " + temp.priority + ") ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Main pq = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            int data = sc.nextInt();
            int priority = sc.nextInt();
            pq.insert(data, priority);
        }
        int removeCount = sc.nextInt();
        for (int i = 0; i < removeCount; i++)
        {
            int removed = pq.remove();
            if (removed == -1) 
            {
                System.out.println("Priority Queue is empty.");
            } 
        }
        pq.display();

    }
}
