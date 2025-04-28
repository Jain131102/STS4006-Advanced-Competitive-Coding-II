import java.util.*;  // for Scanner and Arrays

public class LIS {
    public static void lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int prev[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);

        int ans=1;
        int ansIndex=0;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }

                if(dp[i]>ans)
                {
                    ans=dp[i];
                    ansIndex=i;
                }
            }
        }

        ArrayList<Integer> list=new ArrayList<>();

        while(ansIndex!=-1)
        {
            list.add(nums[ansIndex]);
            ansIndex=prev[ansIndex];
        }

        Collections.reverse(list);
        System.out.println(list);
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the array
        // System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        // System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = lengthOfLIS(nums);

        System.out.println("Length of Longest Increasing Subsequence: " + result);
        
        sc.close();
    }
}
