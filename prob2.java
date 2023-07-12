// Time Complexity : O(n)
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for (int i=1; i<=coins.length; i++)
        {
             dp[i][0] = 1;
            for(int j=1; j<=amount; j++)
            {
                dp[i][j] = dp[i - 1][j];
                if(coins[i-1]<=j)
                {
                    dp[i][j]+=dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}