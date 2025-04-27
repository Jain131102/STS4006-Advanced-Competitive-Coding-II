import java.util.ArrayList;
import java.util.Scanner;

public class Bellman_Ford_Algorithm {

    static class Tuple {
        int src, dest, weight;

        Tuple(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void BellmanFord(ArrayList<Tuple> edge ,int src,int V,int E) {
        int dist[] = new int[V];

        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE; // Initially nothing is reachable

        dist[src] = 0; // We are at src

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge.get(j).src;
                int v = edge.get(j).dest;
                int w = edge.get(j).weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }
        for (int j = 0; j < E; ++j) {
            int u = edge.get(j).src;
            int v = edge.get(j).dest;
            int w = edge.get(j).weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle.");
                return;
            }
        }
        // System.out.println("Vertex Distance from Source");
        // for (int i = 0; i < V; ++i)
        //     System.out.println(i + "\t\t" + dist[i]);

        int sum=0;
        int prod=1;

        for (int i = 0; i < V; ++i)
        {
            if(dist[i]==0 || dist[i]==Integer.MAX_VALUE)
            {
                continue;
            }
            else
            {
                sum+=dist[i];
                prod*=dist[i];
            }

        }

        
        System.out.println("Sum of Shortest Paths: " +sum);
        System.out.println("Product of Shortest Paths: " +prod);
        

        
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V = sc.nextInt(); // 5
        int E = sc.nextInt(); // 7
        ArrayList<Tuple> edge = new ArrayList<>();

        for(int i=0;i<E;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();

            edge.add(new Tuple(u, v, wt));
        }
        // edge.add(new Tuple(0, 1, 5));
        // edge.add(new Tuple(0, 2, 4));
        // edge.add(new Tuple(1, 3, 3));
        // edge.add(new Tuple(2, 1, 6));
        // edge.add(new Tuple(3, 2, 2));
        // edge.add(new Tuple(1, 4, -4));
        // edge.add(new Tuple(4, 2, 2));
        int source =sc.nextInt(); // 0

        sc.close();
        BellmanFord(edge,source,V,E); // 0 is the source vertex
    }
}
