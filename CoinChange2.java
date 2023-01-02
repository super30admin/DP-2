// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChange2 {

    public int changeDp(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 1;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int j = 1; j <= m; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        if (amount < 0) {
            return 0;
        }
        return dp[m][n];
    }
}


//Recursive solution
class Solution {
    public int changeRec(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amount, int index) {
        //base
        if (amount < 0 || index == coins.length) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        //not choose
        int case1 = helper(coins, amount, index + 1);
        //choose
        int case2 = helper(coins, amount - coins[index], index);

        return case1 + case2;
    }
}