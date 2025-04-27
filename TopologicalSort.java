import java.util.*;

class TopologicalSort {

    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int[] d = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                d[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (d[i] == 0) {
                q.offer(i);
            }
        }

        int visitedNodes = 0;
        List<Integer> order = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);

            for (int i : adj.get(u)) {
                d[i]--;

                if (d[i] == 0) {
                    q.add(i);
                }
            }
            visitedNodes++;
        }

        if (visitedNodes != adj.size()) {
            System.out.println("There's a cycle present in the Graph.\nGiven graph is not DAG");
        } else {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int V=sc.nextInt();
        int E=sc.nextInt();

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();

            adj.get(u).add(v);
        }

        sc.close();

        topologicalSort(adj);
    }
}
