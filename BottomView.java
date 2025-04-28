
//User function Template for Java


class Solution
{
    static class Pair{
        Node node;
        int h;
        
        Pair(Node node,int h)
        {
            this.node=node;
            this.h=h;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root==null)
        return list;
        if(root.left==null && root.right==null)
        {
            list.add(root.data);
            return list;
        }
        
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        
        TreeMap<Integer,Integer> map=new TreeMap<>();
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                Pair curr=q.poll();
                map.put(curr.h,curr.node.data);
                
                if(curr.node.left!=null)
                q.offer(new Pair(curr.node.left,curr.h-1));
                if(curr.node.right!=null)
                q.offer(new Pair(curr.node.right,curr.h+1));
            }
        }
        for(int key:map.keySet())
        list.add(map.get(key));
        
        return list;
    }
}
