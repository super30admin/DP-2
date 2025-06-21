// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// used recursion to find the pattern that fills the matrix
// with total ways to find the coins making amount using bottom up approach
public class CoinChangeTwo {
    static int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j]  + dp[i][j- coins[i-1]];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int  amount = 5;
        int[] coins = {1,2,5};
        System.out.println("Ways the coins can make amount: " + change(amount, coins));

    }
}
