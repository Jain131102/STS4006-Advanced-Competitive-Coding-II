import java.util.*;

public class Stock_Span_Problem {
    public static void main(String[] args) {
        // TC -> O(n) SC -> O(n)
        int stock[] = { 7, 2, 1, 3, 3, 1, 8 };
        int ngl[] = new int[stock.length]; // ngl

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < stock.length; i++) {
            while (!s.isEmpty() && stock[s.peek()] <= stock[i])
                s.pop();
            if (s.isEmpty())
                ngl[i] = -1;
            else
                ngl[i] = s.peek();

            s.push(i);
        }

        for (int i = 0; i < stock.length; i++) {
            System.out.print(i - ngl[i] + " ");
        }
        System.out.println();
    }
}
