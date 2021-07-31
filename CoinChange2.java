//https://leetcode.com/problems/coin-change-2/
/*
Time: O(coins*amount)
Space: O(coins*amount)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class CoinChange2 {

    public int change(int[] coins, int amount) {
        int m = coins.length;
        int V = amount;
        int[][] dp = new int[m + 1][V + 1];

        for (int j = 0; j < V + 1; j++)
            dp[0][j] = 0;

        for (int i = 0; i < m + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (j >= coins[i - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];

                else
                    dp[i][j] = dp[i - 1][j];

            }
        }

        return dp[m][V];
    }

}
