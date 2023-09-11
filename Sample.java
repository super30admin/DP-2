                  // Paint House

// Time Complexity : O(n) .. n = length of costs array.
// Space Complexity : O(1) .. if modification to input array is allowed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        
        for(int i=1;i<len;i++){
            for(int j=0;j<costs[0].length;j++){
                if(j == 0)
                    costs[i][j] += Math.min(costs[i-1][1], costs[i-1][2]);
                else if(j == 1)
                    costs[i][j] += Math.min(costs[i-1][0], costs[i-1][2]);
                else costs[i][j] += Math.min(costs[i-1][0], costs[i-1][1]);
            }
        }
        return Math.min(costs[len-1][0], Math.min(costs[len-1][1], costs[len-1][2]));
    }
}

                  // Coin Change II

// Time Complexity : O(mn) .. m = amount, n = length of costs array.
// Space Complexity : O(mn) .. 2D array to store the dp values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[m+1][amount+1];

        for(int i=0;i<m+1;i++)
            dp[i][0] = 1;
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j >= coins[i-1])
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[m][amount];
    }
}

