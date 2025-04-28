/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/
class Solution { // LOT or HV
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        
        if(root==null)
        return result;;
        if(root.left==null && root.right==null)
        {
        
            result.add(new ArrayList<>(Arrays.asList(root.data)));
            return result;
        }
        
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int s=q.size();
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<s;i++)
            {
                Node curr=q.poll();
                list.add(curr.data);
                
                if(curr.left!=null)
                q.offer(curr.left);
                if(curr.right!=null)
                q.offer(curr.right);
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
