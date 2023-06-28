// ## Problem1(https://leetcode.com/problems/paint-house/)
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class PaintHouse {
    public int minCost(int[][] costs) {
        // base
        if (costs == null || costs.length == 0)
            return 0;
        int len = costs.length;
        int[][] dp = new int[len][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        // System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i < len; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);

            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            // System.out.println(Arrays.deepToString(dp));

        }
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));

        // return Math.min(dp[len-1][len-1], Math.min(dp[len-1][len-1],
        // dp[len-1][len-1]));
    }

    public static void main(String[] args) {
        int[][] costs = {
                { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 }
        };
        PaintHouse obj = new PaintHouse();
        System.out.println("Minimum Cost to paint all the houses: " + obj.minCost(costs));
    }
}
