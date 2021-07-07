//========================Coin change II=========================================
// Time Complexity : O(n * m ) where n - Amount and m - Length of the coin array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return 0;
        
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i = 0; i<=n; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1;i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j]; 
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[n][m];
        
    }
}
=============================================Paint House Problem========================================
// Time Complexity :O(n) n is number of houses
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        
        if(costs.length ==0 || costs == null)
            return 0;
        
        for(int i = 1; i < costs.length; i++){
                costs[i][0] = costs[i][0] + Math.min(costs[i-1][1],costs[i-1][2]);
                costs[i][1] = costs[i][1] + Math.min(costs[i-1][0],costs[i-1][2]);
                costs[i][2] = costs[i][2] + Math.min(costs[i-1][1],costs[i-1][1]);
        }
        
        return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}
