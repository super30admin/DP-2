// 518. Coin Change 2 - https://leetcode.com/problems/coin-change-2/
// Time Complexity : O(M)(N)
// Space Complexity : O(M)(N)
// Did this code successfully run on Leetcode : Yes with Time Limit Exceeded
// Any problem you faced while coding this : Time Limit Exceeded

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
        
        int[][]dp = new int[coins.length+1][amount+1];
        
        // first fill column
        for(int i=0;i<=coins.length;i++)
            dp[i][0]=1;
        
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                // amount denomination
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
}