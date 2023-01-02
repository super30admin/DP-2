// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PaintHouse {

    public int minCostDp(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;

        int[][] dp = new int[n][3];
        dp[n - 1][0] = costs[n - 1][0];
        dp[n - 1][1] = costs[n - 1][1];
        dp[n - 1][2] = costs[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    public int minCostRec(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int costRed = helper(costs, 0, 0, 0);
        int costBlue = helper(costs, 0, 1, 0);
        int costGreen = helper(costs, 0, 2, 0);

        return Math.min(costRed, Math.min(costBlue, costGreen));
    }

    private int helper(int[][] costs, int index, int color, int minCost) {
        //base
        if (index == costs.length) {
            return minCost;
        }

        if (color == 0) {
            return Math.min(
                    helper(costs, index + 1, 1, minCost + costs[index][0]),
                    helper(costs, index + 1, 2, minCost + costs[index][0])
            );
        }
        if (color == 1) {
            return Math.min(
                    helper(costs, index + 1, 0, minCost + costs[index][1]),
                    helper(costs, index + 1, 2, minCost + costs[index][1])
            );
        }
        if (color == 2) {
            return Math.min(
                    helper(costs, index + 1, 0, minCost + costs[index][2]),
                    helper(costs, index + 1, 1, minCost + costs[index][2])
            );
        }
        return 6564;
    }
}