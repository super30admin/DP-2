// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class PaintHouse {

  public static int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }

    int[][] dp = new int[3][costs.length];

    for (int idx = 0; idx < costs.length; idx++) {
      if (idx == 0) {
        dp[0][idx] = costs[idx][0];
        dp[1][idx] = costs[idx][1];
        dp[2][idx] = costs[idx][2];
      } else {
        dp[0][idx] = Math.min(dp[1][idx - 1], dp[2][idx - 1]) + costs[idx][0];
        dp[1][idx] = Math.min(dp[0][idx - 1], dp[2][idx - 1]) + costs[idx][1];
        dp[2][idx] = Math.min(dp[0][idx - 1], dp[1][idx - 1]) + costs[idx][2];
      }
    }

    int minResult = Math.min(dp[0][costs.length - 1], dp[1][costs.length - 1]);
    minResult = Math.min(minResult, dp[2][costs.length - 1]);

    return minResult;
  }

  public static void main(String[] args) {
    int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };

    System.out.println(minCost(costs));
  }

}
