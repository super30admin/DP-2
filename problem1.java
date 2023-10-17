//time complexity-O(n)
//space complexity-O(n*3)
//passed all the test cases
//the appraoch is to first paint a house with a color and ensure that same color is not painted for the next house
public class Solution {
    public static int minCost(int[][] cost) {
        // Write your code here.
        int n = cost.length;
        int dp[][] = new int[n][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}