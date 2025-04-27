import java.util.*; // for Scanner

public class RodCutting {

    static int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n + 1];

        // Find maximum value for all rod of length i
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        // System.out.print("Enter the length of the rod: ");
        int n = sc.nextInt();

        int[] price = new int[n];
        // System.out.println("Enter the prices for each piece length (1 to " + n + "):");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        int maxProfit = cutRod(price);

        System.out.println("Maximum Obtainable Value is: " + maxProfit);

        sc.close();
    }
}
