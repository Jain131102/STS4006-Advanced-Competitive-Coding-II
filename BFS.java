import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
     public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[]=new boolean[adj.size()];
        ArrayList<Integer> bfs=new ArrayList<Integer>(); 
        Queue<Integer> q=new LinkedList<>();
        
        visited[0]=true;
        q.offer(0);
        
        while(!q.isEmpty())
        {
            int x=q.poll();
            bfs.add(x);
            
            for(int neighbours:adj.get(x))
            {
                if(!visited[neighbours])
                {
                    visited[neighbours]=true;
                    q.offer(neighbours);
                }
            }
        }
        
        return bfs;
        
    }
}
