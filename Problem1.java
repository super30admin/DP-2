/* Paint House: Finding minimum cost to paint houses

/*Approach 2: Top down dynamic approach-mutation
// Time Complexity : O(m*n) where m is cost to paint and n is number of colors (n=3)
// Space Complexity : O(1) since we are not using any auxiliary space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// here the cost of painting house is represented by nx3 matrix and we have to calculate
// the minimum cost to paint all houses and no two adjacent houses will have same color
//approach: we will be using top down dynamic programming approach-we will calculate the cost by finding
// the minimum cost of painting the adjacent houses with either of the other colors
// and coloring the current house with 3rd remaining color.
// then we will find the minimum of resultant of three possibilities and return that as answer
*/


class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        //edge case
        if(costs == null || m == 0) return 0;
        //Mutation-No auxiliary space
        for(int i = 1; i < m; i++){
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[m-1][0], costs[m-1][1]), costs[m-1][2]);

    }
}

/*Approach 2: Top down dynamic approach-Non mutation
// Time Complexity : O(m*n) where m is cost to paint and n is number of colors (n=3)
// Space Complexity : constant 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        //edge case
        if(costs == null || m == 0) return 0;
        //Non mutation approach: intialise dp matrix
        int [][] dp = new int[m][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i = 1; i < m; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(Math.min(dp[m-1][0], dp[m-1][1]), dp[m-1][2]);

    }
}
*/