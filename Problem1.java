// Time Complexity :
//      n - number of coins, k - amount
//      change() - O(n*k)
//      
// Space Complexity :
//      change() - O(n*k)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem1 {
    public int change(int amount, int[] coins) {
        //edge case
        if(amount == 0)
            return 1;
        
        if(coins == null || coins.length == 0)
            return 0;
        
        int m = coins.length+1;
        int n = amount + 1;
        
        int[][] dp = new int[m][n];
        
        for(int i=1; i <m; ++i)
        {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < m; ++i)
        {
            for(int j = 1; j < n ; ++j)
            {
                if(j >= coins[i-1])
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}