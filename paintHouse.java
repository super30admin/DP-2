// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    public static int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        // dp table
        int[][] dp = new int[m][n];

        // intlially store last row value into the dp table
        for (int i = 0; i < costs[0].length; i++) {
            dp[m - 1][i] = costs[m - 1][i];
        }

        // traveres from second last row and for each column take minimum values that
        // can be add from the next row that is not same as current column and store it
        // in dp table
        for (int i = m - 2; i >= 0; i--) {
            dp[i][0] = Math.min(costs[i][0] + dp[i + 1][1], costs[i][0] + dp[i + 1][2]);
            dp[i][1] = Math.min(costs[i][1] + dp[i + 1][0], costs[i][1] + dp[i + 1][2]);
            dp[i][2] = Math.min(costs[i][2] + dp[i + 1][0], costs[i][2] + dp[i + 1][1]);
        }

        // return minimum value from the top row
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    public static void main(String[] args) {
        int[][] costs = {
                { 17, 2, 17 },
                { 16, 16, 5 },
                { 14, 3, 19 }
        };
        System.out.println("minCost to paint the house is: " + minCost(costs));
    }
}