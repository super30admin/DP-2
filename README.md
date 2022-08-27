# DP-2

## Problem1: Paint House

```Java
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        
        int n = costs.length;
        int[][] dp = new int[n][3]; //[houses][colors]
        
        for(int j=0;j<3;j++){
            dp[n-1][j] = costs[n-1][j];
        }
        
        for(int i=n-2;i>=0;i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

```

## Problem2: Coin Change - 2

```Java
// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
       
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        
        dp[0][0] = 1;
        
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }   
}
```

