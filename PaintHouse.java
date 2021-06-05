// Time Complexity : O (n * 3) == O(m) where n is the number of houses or rows
// Space Complexity : O (n * 3) == O(m) where n is the number of houses or rows
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Recursive Approach

/**
 * In this problem, we have three choices for any house (Red(0), Blue(0), green(2))
 * If we are choosing a color for a house, we skip that color for the next house and pursue other 2 colors for the next house as this is the constraint
 * Finally we return the minimum of the three cases.
 */

class PaintHouse {

    public int minCost(int[][] costs) {
            
        // red = 0, blue = 1, green = 2
        // Index is the row or the house
        int red_case = helper(costs,0,0,0);
        int blue_case = helper(costs,1,0,0);
        int green_case = helper(costs,2,0,0);
        
        return Math.min(red_case, Math.min(blue_case, green_case));
    }

    private int helper(int[][] costs, int color, int index, int min_cost) {
        
        // base case
        if(index == costs.length) {
            return min_cost;
        }
        
        if(color == 0) {
            return Math.min(helper(costs, 1, index + 1, min_cost + costs[index][0]), helper(costs, 2, index + 1, min_cost + costs[index][0]));
        }
        
        if(color == 1) {
            return Math.min(helper(costs, 0, index + 1, min_cost + costs[index][1]), helper(costs, 2, index + 1, min_cost + costs[index][1]));
        }
        
        if(color == 2) {
            return Math.min(helper(costs, 0, index + 1, min_cost + costs[index][2]), helper(costs, 1, index + 1, min_cost + costs[index][2]));
        }
        
        return -1;
    }
}
// Dynamic programming approach

class Solution {
    public int minCost(int[][] costs) {
        
        // red = 0, blue = 1, green = 2
        // Index is the row or the house
        
        int[][] dp = new int[costs.length][3];
        
        dp[dp.length-1][0] = costs[costs.length-1][0];
        dp[dp.length-1][1] = costs[costs.length-1][1];
        dp[dp.length-1][2] = costs[costs.length-1][2];
        
        for(int i=dp.length - 2;i>=0;i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    /**
     * we can also optimize the solution by modifying the same matrix itself
     * Space complexity will be better in such case
     */
}

