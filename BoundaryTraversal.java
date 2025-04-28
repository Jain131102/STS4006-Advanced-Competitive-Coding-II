
// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    public void left(Node root,ArrayList<Integer> ans)
    {
        if(root==null || root.left==null && root.right==null)
        return;
        
        ans.add(root.data);
        if(root.left!=null)
        {
            left(root.left,ans);
        }
        else
        {
            left(root.right,ans);
        }
        
    }
    public void right(Node root,ArrayList<Integer> ans)
    {
        if(root==null || root.left==null && root.right==null)
        return;
        
        
        if(root.right!=null)
        {
            right(root.right,ans);
        }
        else
        {
            right(root.left,ans);
        }
        ans.add(root.data);
        
    }
    public void leaf(Node root,ArrayList<Integer> ans)
    {
        if(root==null)
        return;
        if(root.left==null && root.right==null)
        ans.add(root.data);
        
            leaf(root.left,ans);
            leaf(root.right,ans);
        
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(root.data);
        
        if(root.left==null && root.right==null)
        return ans;
        
        left(root.left,ans);
        leaf(root,ans);
        right(root.right,ans);
        
        return ans;
    }
}
