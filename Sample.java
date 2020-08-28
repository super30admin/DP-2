// Problem1
// Time Complexity : O(n)
// Space Complexity : O(1) -> no extra spcae, input is being manipulated
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach
// 1 - loop over costs array starting from index 1
// 2 - update cost by adding previous minimum cost from remaning 2 colors
// 3 - return min of last 
class Solution {
    public int minCost(int[][] costs) {
        if (costs.length < 1) {
            return 0;
        }
        
        // 1
        for (int i=1; i<costs.length; i++) {
            // 2
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        // 3
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}

// Problem2
// Time Complexity : O(n * l) where n = length of coins array, l = amount
// Space Complexity : O(n * l) -> extra space for 2d array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze 2D dp array of length and amount + 1
// 2 - iterate over coins array length and amount
// 3 - if amount less than current coin then current is previous coin
// 4 - else amount is previous coin's value plus current amount minus coin value
// 5 - return last element
class Solution {
    public int change(int amount, int[] coins) {
        // 1
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i=0; i<=coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int j=1; j<=amount; j++) {
            dp[0][j] = 0;
        }
        
        // 2
        for (int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                // 3
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else { // 4
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        // 5   
        return dp[coins.length][amount];
    }
}