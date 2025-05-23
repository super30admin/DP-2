// Time Complexity O(n)
// Space Complexity O(n)
// Runs on LeetCode: No premium question

public class PaintHouse {
    public int minCost(int[][] costs) {
        int rows = costs.length;
        int cols = costs[0].length;
        int[][] dp = new int[rows][cols];


        for(int i=0; i< cols; i++){
            dp[rows -1][i] = costs[rows -1][i];
        }

        for(int i = rows -2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
