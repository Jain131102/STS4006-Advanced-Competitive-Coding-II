import java.util.*;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int n = nums.length; // n=8 k=3
        int[] result = new int[n - k + 1];
        int p=0;

        for(int i=0;i<=n-k;i++) // 0 1 2 3 4 5
        {
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++)
            {
                max=Math.max(max,nums[j]);
            }
            result[p]=max;
            p++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
