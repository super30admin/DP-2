256.Paint House
        There is a row of n houses,where each house can be painted one of three colors:red,blue,or green.The cost of painting each house with a certain color is different.You have to paint all the houses such that no two adjacent houses have the same color.

        The cost of painting each house with a certain color is represented by an n x 3cost matrix costs.

        For example,costs[0][0]is the cost of painting house 0with the color red;costs[1][2]is the cost of painting house 1with color green,and so on...
        Return the minimum cost to paint all houses.

        Example 1:
        Input:costs=[[17,2,17],[16,16,5],[14,3,19]]
        Output:10
        Explanation:Paint house 0into blue,paint house 1into green,paint house 2into blue.
        Minimum cost:2+5+3=10.

        Example 2:
        Input:costs=[[7,6,2]]
        Output:2

        Constraints:
        costs.length==n
        costs[i].length==3
        1<=n<=100
        1<=costs[i][j]<=20


Approach1-------------------------------------->  DP

// Time Complexity : O(N)
// Space Complexity : O(1) as we are mutating the same matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 we do Bottom up approach where we calculate the curr color + minimum of next row's 2 possible colors.
 So each row will have possible accumulated minimum values and returns to top row. Return Min of top row
 */
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.min(costs[i + 1][1], costs[i + 1][0]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}



Approach 2----------------------------------->  Brute Force
// Time Complexity : O(2^3*N) = O(2^N)
// Space Complexity : O(3*N) = O(N)
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
checking recursively possibilities for each color and fetching the minimum possibility among 2 options left after choosing one color for the presvious house.
Return min of 3 cases
 */
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        //costs, row, col, minCost
        int case1 = helper(costs, 0, 0, 0);
        int case2 = helper(costs, 0, 1, 0);
        int case3 = helper(costs, 0, 2, 0);

        return Math.min(case1, Math.min(case2, case3));
    }

    private int helper(int[][] costs, int row, int color, int minCost) {
        //base
        if (row == costs.length) return minCost;
        if (color == 0) {
            return Math.min(
                    helper(costs, row + 1, 1, minCost + costs[row][color]),
                    helper(costs, row + 1, 2, minCost + costs[row][color]));
        } else if (color == 1) {
            return Math.min(
                    helper(costs, row + 1, 0, minCost + costs[row][color]),
                    helper(costs, row + 1, 2, minCost + costs[row][color]));
        } else {
            return Math.min(
                    helper(costs, row + 1, 0, minCost + costs[row][color]),
                    helper(costs, row + 1, 1, minCost + costs[row][color]));
        }
    }
}