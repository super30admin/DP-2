// ## Problem2 (https://leetcode.com/problems/coin-change-2/)
// Time Complexity : O (m*n) where m = amount, n = size of coins array
// Space Complexity : O (m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Our code uses a 2D array, dp, of size (coins.length + 1) x (amount + 1) to store the computed values for the dynamic programming approach. Each cell in the array represents the number of ways to make change for a specific coin and amount combination.
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if (coins == null)
            return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 1; // Very Important to understand

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange2 obj = new CoinChange2();

        int[] coins = { 1, 2, 5 };
        int amount = 5;
        System.out.println(obj.change(amount, coins));
    }
}
