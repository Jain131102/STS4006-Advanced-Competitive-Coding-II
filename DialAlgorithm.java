import java.util.*;

public class DialAlgorithm {
    static class Edge {
        int v, wt;

        Edge(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static int[] shortestPath(List<List<Edge>> graph, int src, int maxWt) {
        int V = graph.size(); // size of graph
        int[] d = new int[V]; // creating array to store minimum
        Arrays.fill(d, Integer.MAX_VALUE); // initially all distances are set to infinite 
        d[src] = 0; // we set src distance to 0

        // initializing the buckets ds
        List<Queue<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxWt * V; i++) // maxWt * V
            buckets.add(new LinkedList<>());
        buckets.get(0).add(src);

        int i = 0;
        while (i < buckets.size()) {
            while (!buckets.get(i).isEmpty()) {
                int u = buckets.get(i).poll();
                if (d[u] < i)
                    continue; // skip as we have already found a better distance 

                    // relax all neighbours and update the buckets 
                for (Edge edge : graph.get(u)) { 
                    int v = edge.v, wt = edge.wt;
                    if (d[u] + wt < d[v]) {
                        d[v] = d[u] + wt;
                        buckets.get(d[v]).add(v);
                    }
                }
            }
            // look for next non-empty bucket
            while (i < buckets.size() && buckets.get(i).isEmpty())
                i++;
        }
        return d;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> graph = new ArrayList<>(Collections.nCopies(V, new ArrayList<>()));

        graph.set(0, Arrays.asList(new Edge(1, 2), new Edge(2, 3)));
        graph.set(1, Arrays.asList(new Edge(2, 1), new Edge(3, 1)));
        graph.set(2, Arrays.asList(new Edge(3, 4)));
        graph.set(3, Arrays.asList(new Edge(4, 2)));
        graph.set(4, Arrays.asList(new Edge(5, 1)));

        int[] d = shortestPath(graph, 0, 4);

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("To node " + i + ": " + d[i]);
        }
    }
}
