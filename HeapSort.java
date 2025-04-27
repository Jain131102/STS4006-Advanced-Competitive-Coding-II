import java.util.*;
public class HeapSort {

    public static void heapify(int nums[],int n,int i)
    {
        int largest=i;

        int l=2*i+1;
        int r=2*i+2;

        if(l<n && nums[largest]<nums[l])
        largest=l;
        if(r<n && nums[largest]<nums[r])
        largest=r;

        if(largest!=i)
        {
            int temp=nums[largest];
            nums[largest]=nums[i];
            nums[i]=temp;

            heapify(nums, n, largest);
        }

    }

    public static void heapSort(int nums[],int n)
    {
        for(int i=n/2-1;i>=0;i--)
        {
            heapify(nums, n, i);
        }
        for(int i=n-1;i>0;i--)
        {
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;

            heapify(nums, i, 0);
        }
    } 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int nums[]=new int[n];

        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

        heapSort(nums, n);
        System.out.println(Arrays.toString(nums));
    }
}
