// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        // // 2D DP
        // int[][] dp = new int[coins.length+1][amount+1];
        // dp[0][0] = 1;
        // for(int i = 1; i <= coins.length; i++)
        // {
        //     for(int j = 0; j <= amount; j++)
        //     {
        //         if(coins[i-1] > j)
        //         {
        //             dp[i][j] = dp[i-1][j];
        //         }
        //         else
        //         {
        //             dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
        //         }
        //     }
        // }

        // return dp[coins.length][amount];

        // 1D DP
        int dp[] = new int[amount+1];
        dp[0] = 1;
        for(int i = 1; i <= coins.length; i++)
        {
            for(int j = 0; j <= amount; j++)
            {
                if(coins[i-1] > j)
                {
                    dp[j] = dp[j];
                }
                else
                {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }
}