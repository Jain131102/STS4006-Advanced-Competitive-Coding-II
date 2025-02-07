import java.util.*;
class MinStack 
{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x)
    {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) 
        {
            minStack.push(x);
        }
    }

    public void pop() 
    {
       if (!stack.isEmpty()) 
       {
          if (stack.peek().equals(minStack.peek())) 
          {
             minStack.pop();
          }
            stack.pop();
        }
    }

    public int top() 
    {
        if (stack.isEmpty()) 
            return -1; 
        return stack.peek();
    }

    public int getMin() 
    {
        if (minStack.isEmpty()) 
            return -1; 
        return minStack.peek();
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        MinStack minStack = new MinStack();
        int operations = sc.nextInt();
        for (int i = 0; i < operations; i++) 
        {
            String operation = sc.next();
            switch (operation) 
            {
                case "push":
                    int value = sc.nextInt();
                    minStack.push(value);
                    break;

                case "pop":
                    minStack.pop();
                    break;

                case "top":
                    System.out.println(minStack.top());
                    break;

                case "getMin":
                    System.out.println(minStack.getMin());
                    break;

                default:
                    System.out.println("Invalid operation");
                    break;
            }
        }
    }
}
