// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// LC 256- Paint Houses

class PaintHouses {
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0 || costs[0].length == 0) {
      return 0;
    }

    for (int i = 1; i < costs.length; i++) {
      costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
    }

    int len = costs.length;

    return Math.min(Math.min(costs[len - 1][0], costs[len - 1][1]), costs[len - 1][2]);
  }
}