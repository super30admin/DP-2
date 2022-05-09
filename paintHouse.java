// Time Complexity :O(2^n-1) where n is no of rows
// Space Complexity :height of the tree
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :no
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int red = helper(costs, 0, 0, 0);
        int blue = helper(costs, 1, 0, 0);
        int green = helper(costs, 2, 0, 0);
        return Math.min(red, Math.min(blue, green));// we'll take minimum of three
    }

    public int helper(int[][] costs, int color, int row, int cost) {
        // base case
        if (row >= costs.length)
            return cost;
        // logic
        if (color == 0) {// if color is red we'll take min of blue and green
            return Math.min(helper(costs, 1, row + 1, cost + costs[row][0]),
                    helper(costs, 2, row + 1, cost + costs[row][0]));
        }
        if (color == 1) {// if color is blue we'll take min of red and green
            return Math.min(helper(costs, 0, row + 1, cost + costs[row][1]),
                    helper(costs, 2, row + 1, cost + costs[row][1]));
        }
        if (color == 2) {// if color is green we'll take min of blue and red
            return Math.min(helper(costs, 1, row + 1, cost + costs[row][2]),
                    helper(costs, 0, row + 1, cost + costs[row][2]));
        }
        return -1;
    }
}

// ----------------OPTIMIZED-------------------
// Time Complexity :O(n)
// Space Complexity :O(n) where n is no of rows
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// we are making new 2d array of same size as input and at every index we store
// maximum of that path.we can also overwrite costs/input array and return
// minimum of three values we have at top/0 index
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int row = costs.length;
        int column = costs[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < 3; i++) {
            dp[row - 1][i] = costs[row - 1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][0] = Math.min(dp[i + 1][1] + costs[i][0], dp[i + 1][2] + costs[i][0]);
            dp[i][1] = Math.min(dp[i + 1][0] + costs[i][1], dp[i + 1][2] + costs[i][1]);
            dp[i][2] = Math.min(dp[i + 1][1] + costs[i][2], dp[i + 1][0] + costs[i][2]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

// -----------------USING ONE ROW ONLY---------------------
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// we are overwriting in the same row ,we can use three variables in place of
// one row having 3 columns

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int row = costs.length;
        int column = costs[0].length;
        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println(row + "row");
            dp[i] = costs[row - 1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            int red = dp[0];
            int blue = dp[1];
            dp[0] = Math.min(dp[1] + costs[i][0], dp[2] + costs[i][0]);
            dp[1] = Math.min(red + costs[i][1], dp[2] + costs[i][1]);
            dp[2] = Math.min(blue + costs[i][2], red + costs[i][2]);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}