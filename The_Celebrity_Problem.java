import java.util.*;
public class The_Celebrity_Problem {
    // Celebrity : Knows no one | Everyone knows him
    public static boolean knows(int a,int b, int mat[][])
    {
        return mat[a][b]==1;// means a knows b = true else false
    }
    public static void main(String[] args) {
        // TC - O(n) SC - O(n) Approach 3 -> Best
        int mat[][] = { { 0, 1, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        int n = mat.length;

        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++)
        {
            s.push(i);
        }
        while(s.size()>1)
        {
            int a=s.pop();
            int b=s.pop();

            if(knows(a, b, mat))
            s.push(b);
            else
            s.push(a);
        }
        int candidate=s.pop();

        for(int i=0;i<n;i++)
        {
            if(i!=candidate && (knows(candidate, i, mat) || !knows(i, candidate, mat)))
            {
                System.out.println("No Celebrity");
                return;
            }
        }
        System.out.println(candidate+" th person is celebrity");
    }

}
