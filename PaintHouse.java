// Bottom up dp
// Time Complexity : O(N)
// Space Complexity : O(N) - Number of Houses - Color is constant :: 3
// Did this code successfully run on Leetcode : yes
class PaintHouse {
    public int minCost(int[][] costs) {

        if (costs == null || costs.length == 0) return 0;

        int n = costs.length;

        int[][] dp = new int[n][3];

        // Initialize dp array last roq -> we are going bottom up
        dp[n - 1][0] = costs[n - 1][0];
        dp[n - 1][1] = costs[n - 1][1];
        dp[n - 1][2] = costs[n - 1][2];

        // start from the second last row
        for (int i = n - 2; i >= 0; i--) {

            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);

        }

        // return the result from first row
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

}

//This is Exhaustive approach based on Pick and Non-pick
// Time Complexity : O(2 ^ N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No -> Getting Time limit exceeded error
/*
class Solution {

    private int helper(int[][] costs, int house, int color, int min) {

        // Done with all the houses
        if(house == costs.length) return min;

        // Paint the house
        if(color == 0) {
            return Math.min(helper(costs, house + 1, 1, min + costs[house][color]),
                    helper(costs, house + 1, 2, min + costs[house][color]));
        }

        if(color == 1) {
            return Math.min(helper(costs, house + 1, 0, min + costs[house][color]),
                    helper(costs, house + 1, 2, min + costs[house][color]));
        }

        if(color == 2) {
            return Math.min(helper(costs, house + 1, 0, min + costs[house][color]),
                    helper(costs, house + 1, 1, min + costs[house][color]));
        }

        // To satisfy the compiler
        return 0;

    }

    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) return 0;

        // Paint All Houses
        // Select any one of the color first and start paining all the houses

        int r = helper(costs, 0, 0, 0);
        int b = helper(costs, 0, 1, 0);
        int g = helper(costs, 0, 2, 0);

        return Math.min(r, Math.min(b, g));
    }

}
*/