// User function Template for Java

/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root==null)
        return list;
        if(root.left==null && root.right==null)
        {
            list.add(root.data);
            return list;
        }
        
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                Node curr=q.poll();
                if(i==s-1)
                list.add(curr.data);
                
                if(curr.left!=null)
                q.offer(curr.left);
                if(curr.right!=null)
                q.offer(curr.right);
            }
        }
        return list;
    }
}
