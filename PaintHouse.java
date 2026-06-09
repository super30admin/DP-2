// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//  We can use a top down approach to solve this problem. 
// We will start from the first house and try to paint it with all the three colors and then we will move to the next house and try to paint it with the remaining two colors and so on.
//  We will keep track of the minimum cost for each color for each house in a dp array.
//  Finally, we will return the minimum cost among the three colors for the last house.


class Solution {

    int[][] dp;

    public int minCost(int[][] costs) {

        int n = costs.length;

        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }

        int colorR = helper(costs, 0, 0);
        int colorB = helper(costs, 0, 1);
        int colorG = helper(costs, 0, 2);

        return Math.min(colorR, Math.min(colorB, colorG));
    }

    private int helper(int[][] costs, int idx, int color) {

        if (idx == costs.length) {
            return 0;
        }

        if (dp[idx][color] != -1) {
            return dp[idx][color];
        }

        int res = 0;

        if (color == 0) {

            res = costs[idx][0] +
                    Math.min(helper(costs, idx + 1, 1),
                             helper(costs, idx + 1, 2));

        } else if (color == 1) {

            res = costs[idx][1] +
                    Math.min(helper(costs, idx + 1, 0),
                             helper(costs, idx + 1, 2));

        } else {

            res = costs[idx][2] +
                    Math.min(helper(costs, idx + 1, 0),
                             helper(costs, idx + 1, 1));
        }

        dp[idx][color] = res;
        return res;
    }
}