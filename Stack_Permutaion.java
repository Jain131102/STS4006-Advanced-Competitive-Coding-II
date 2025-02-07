import java.util.*;
class Stack_Permutaion {
    public static int isStackPermutation(int n, int[] ip, int[] op) {
        
        int j=0;
        Stack<Integer> s=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            s.push(ip[i]);
            
            if(s.peek()==op[j])
            {
                while(!s.isEmpty() && s.peek()==op[j])
                {
                    s.pop();
                    j++;
                }
            }
        }
        
        if(s.isEmpty())
        return 1;
        else
        return 0;
        
    }
}
