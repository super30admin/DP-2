// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
## Problem2 (https://leetcode.com/problems/coin-change-2/)

class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp [i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}


## Problem1(https://leetcode.com/problems/paint-house/)

// Time complexity - here is exponential and the code gives Time Limit exceeded exception

// 1st approach

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int caseR = helper(costs, 0, 0, 0);
        int caseB = helper(costs, 0, 1, 0);
        int caseG = helper(costs, 0, 2, 0);
        return Math.min(caseR, Math.min(caseB, caseG));
    }
    private int helper(int[][] costs, int index, int color, int cost) {
        if (index == costs.length) {
            return cost;
        }
        if (color == 0) {
            return Math.min(helper(costs, index + 1, 1, cost + costs[index][0]), 
            helper(cost, index + 1, 2, cost + costs[index][0]));
        }
        else if (color == 1) {
            return Math.min(helper(costs, index + 1, 0, cost + costs[index][1]),
            helper(cost, index + 1, 2, cost + costs[index][1]));
        }
        else {
            return Math.min(helper(costs, index + 1, 0, cost + costs[index][2]),
            helper(cost, index + 1, 1, cost + costs[index][2]))
        }
    }
}


// 2nd approach (by moving bottom to top)

// Time Complexity - 0(n) because the code iterates over each row of the matrix exactly once in the for-loop.
// Space Complexity - 0(1) because the code does not use any extra space proportional to the size of the input

class Solution {
    public int minCost(int[][] costs) {
         if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        for (int i = n - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
       