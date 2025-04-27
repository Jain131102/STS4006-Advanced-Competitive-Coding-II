import java.util.*;

public class VerticalOrderTraversal {
    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int data) {
            val = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tuple {
        TreeNode node;
        int v, l;

        Tuple(TreeNode node, int v, int l) {
            this.node = node;
            this.v = v;
            this.l = l;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(Arrays.asList(root.val)));
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int v = t.v;
            int l = t.l;

            if (!map.containsKey(v))
                map.put(v, new TreeMap<>());
            if (!map.get(v).containsKey(l))
                map.get(v).put(l, new PriorityQueue<>());
            map.get(v).get(l).offer(node.val);

            if (node.left != null)
                q.offer(new Tuple(node.left, v - 1, l + 1));

            if (node.right != null)
                q.offer(new Tuple(node.right, v + 1, l + 1));
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> m : map.values()) {
            List<Integer> subResult = new ArrayList<>();
            for (PriorityQueue<Integer> pq : m.values()) {
                    subResult.addAll(pq);
            }
            result.add(new ArrayList<>(subResult));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        sc.close();

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        for (int i = 0; i <= n / 2; i++) {
            TreeNode node = q.poll();
            int l = 2 * i + 1;
            int r = 2 * i + 2;

            if (l < n) {
                node.left = new TreeNode(arr[l]);
                q.offer(node.left);
            }
            if (r < n) {
                node.right = new TreeNode(arr[r]);
                q.offer(node.right);
            }
        }

        List<List<Integer>> ans=verticalTraversal(root);
        System.out.println(ans);
    }
}
