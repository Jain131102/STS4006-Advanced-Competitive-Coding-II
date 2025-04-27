import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RecoverBST {
    static ArrayList<Integer> list=new ArrayList<>();
    static int i=0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void inorder1(TreeNode root)
    {
        if(root==null)
        return;

        inorder1(root.left);
        list.add(root.val);
        inorder1(root.right);
    }

    public static void inorder2(TreeNode root)
    {
        if(root==null)
        return;

        inorder2(root.left);
        root.val=list.get(i);
        i++;
        inorder2(root.right);
    }

    public static void inorder3(TreeNode root)
    {
        if(root==null)
        return;

        inorder3(root.left);
        System.out.print(root.val +" ");
        inorder3(root.right);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        sc.close();

        TreeNode root=new TreeNode(arr[0]);
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        for(int i=0;i<=n/2;i++)
        {
            TreeNode node=q.poll();
            int l=2*i+1;
            int r=2*i+2;

            if(l<n)
            {
                node.left=new TreeNode(arr[l]);
            q.offer(node.left);
            }
            if(r<n)
            {
                node.right=new TreeNode(arr[r]); 
            q.offer(node.right);
            }

        }
        
        inorder1(root);
        Collections.sort(list);
        inorder2(root);
        inorder3(root);
    }
}
