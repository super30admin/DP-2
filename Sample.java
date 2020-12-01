// Time Complexity :O(2n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : Very difficult to work


// Your code here along with comments explaining your approach
// Paint House

class Solution {

    private int[][] costs;

    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCost(int n, int color) {
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }        
        return totalCost;
    }
}

// Time Complexity :O(2n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : Very difficult to work


// Your code here along with comments explaining your approach

//coin change 2
class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}