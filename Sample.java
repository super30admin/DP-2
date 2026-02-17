// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Sample {
    // Time Complexity : O(N * amount)
    // Space Complexity : O(amount)
    // Did this code successfully run on Leetcode : Yes it did


    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;  // One way to make amount 0

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N) since there are only 3 colors
    // Did this code successfully run on Leetcode : Yes it did


    public int minCost(int[][] costs) {

        if (costs == null || costs.length == 0) return 0;

        for (int i = 1; i < costs.length; i++) {

            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        int n = costs.length - 1;

        return Math.min(
                costs[n][0],
                Math.min(costs[n][1], costs[n][2])
        );
    }

    // Time Complexity : O(N^2)
    // Space Complexity : O(N^2)
    // Did this code successfully run on Leetcode : Yes it did
    // Challenge was to determine whether we need 2D matrix or just an array can work too



    public int minFallingPathSum(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] minSum = new int[rows][cols];

        // Initialize first row
        for (int j = 0; j < cols; j++) {
            minSum[0][j] = matrix[0][j];
        }

        // Build DP table
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                minSum[i][j] = matrix[i][j] + minSum[i - 1][j];

                if (j - 1 >= 0) {
                    minSum[i][j] = Math.min(minSum[i][j],
                            matrix[i][j] + minSum[i - 1][j - 1]);
                }

                if (j + 1 < cols) {
                    minSum[i][j] = Math.min(minSum[i][j],
                            matrix[i][j] + minSum[i - 1][j + 1]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < cols; j++) {
            ans = Math.min(ans, minSum[rows - 1][j]);
        }

        return ans;
    }
}