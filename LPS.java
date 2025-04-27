import java.util.Scanner;

public class LPS {
    
    public static int longestPalindromeSubseq(String s) {
        String text1 = s;
        String text2 = new StringBuilder(s).reverse().toString();

        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the string: ");
        String input = sc.nextLine();
        sc.close();
        
        int result = longestPalindromeSubseq(input);
        System.out.println("Length of Longest Palindromic Subsequence: " + result);
    }
}
