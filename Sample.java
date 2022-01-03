// Time Complexity :O(N*amount)
// Space Complexity :O(Amount)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        
        int [] dp = new int [amount+1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i=coin; i<=amount; i++)
                dp[i] += dp[i-coin];
        }
        return dp[amount];
        
        
        // bottom up knapsack idea
        int length = coins.length;
        int [][] dp = new int [length+1][amount+1];
        dp[0][0] = 1;
        for (int i=1; i<=length; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - coins[i-1] >= 0)
                    dp[i][j] += dp[i][j - coins[i-1]];
            }
        }
        return dp[length][amount];
    }
}



//Time complexity : O(2^N)
//Space complexity : O(N) 

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0)
            return 0;
        if(costs[0].length == 0)
            return 0;
        for(int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]),
                        costs[costs.length - 1][2]);
    }
}
