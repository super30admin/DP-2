// Time Complexity :O(number of coins * Amount)
// Space Complexity : O(Amount) + O(number of coins)  = O(Amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int [][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i =1;i <=m; i++)
        {
            for(int j=0; j<=n; j++)
            {   
                //current amount < coins denomination
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}