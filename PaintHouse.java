//Time Complexity: O(n), where n is the number of houses. We need to iterate through each house once.
// Space Complexity: O(n), where n is the number of houses. We are using a 2D array to store the minimum costs for each house and color.

// LeetCode: https://leetcode.com/problems/paint-house/

/**
 * Uses dynamic programming to calculate the minimum cost to paint all houses.
 * It iterates through the houses from bottom to top, storing the minimum cost of painting each house with each color.
 * At each house, it ensures that no two adjacent houses are painted with the same color by taking the minimum cost from the previous house's other two colors.
 */


public class PaintHouse {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length; 

        int[][] dp = new int[m][n];
        
        //Bottom UP
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i = m -2 ; i >=0 ; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
