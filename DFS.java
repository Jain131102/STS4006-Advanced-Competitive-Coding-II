import java.util.ArrayList;
import java.util.Stack;

public class DFS {
     public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> dfs=new ArrayList<>();
        boolean visited[]=new boolean[adj.size()];
        Stack<Integer> s=new Stack<>();
        
        s.push(0);
        
        while(!s.isEmpty())
        {
            int x=s.pop();
            if(!visited[x])
            {
                dfs.add(x);
                visited[x]=true;
                for(int i=adj.get(x).size()-1;i>=0;i--)
                {
                    if(!visited[adj.get(x).get(i)])
                    s.push(adj.get(x).get(i));
                }
            }
        }
        return dfs;
    }
}
