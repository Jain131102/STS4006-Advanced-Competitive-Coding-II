import java.util.*; // for Scanner

public class Knapsack01 {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking inputs
        // System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        // System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        // System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        // System.out.print("Enter the maximum capacity of the knapsack: ");
        int W = sc.nextInt();

        int maxValue = knapsack(W, val, wt);

        System.out.println("Maximum value that can be obtained: " + maxValue);

        sc.close();
    }
}
