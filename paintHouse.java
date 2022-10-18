// TC: O(n)
// SC: O(n)

// Approach: Again a 0/1 knapsack variation.


class Solution {

  private int solve(int[][] costs, int n, int i, int[] col, int idx, int[][] dp) {

    if(idx >= n) {
      return 0;
    }

    if(dp[idx][i%3] != -1) {
      return dp[idx][i%3];
    }


    int paint = costs[idx][i%3] + solve(costs, n, i+1, col, idx+1, dp);
    int paint1 = costs[idx][i%3] + solve(costs, n, i+2, col, idx+1, dp);


    return dp[idx][i%3] = Math.min(paint, paint1);
  }

  public int minCost(int[][] costs) {
    int n = costs.length;
    int [] cols = new int[] {0,1,2};
    int[][] dp = new int[costs.length][cols.length];
    for(int[] arr: dp) {
      Arrays.fill(arr, -1);
    }
    int ans = Integer.MAX_VALUE;
    for(int i=0; i<3; i++) {
      ans = Math.min(ans, solve(costs, n, i, cols, 0, dp));
    }


    return ans;
  }
}