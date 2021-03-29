// Time Complexity : O(n * 3)
// Space Complexity : O(n * 3)
// n is the length of the cost array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Paint House
class Solution {
    Integer [][] dp;
    public int minCost(int[][] costs) {
        dp = new Integer[costs.length + 1][3];
        return Math.min(paintHouse(costs, 0, 0), Math.min(paintHouse(costs,0, 1), paintHouse(costs, 0, 2)));
    }
    public int paintHouse(int [][] costs, int houseNumber, int color) {
        if(houseNumber == costs.length) {
            return 0;
        }
        else if(dp[houseNumber][color] != null) {
            return dp[houseNumber][color];
        }
        int totalCost = costs[houseNumber][color];
        if(color == 0) {
            totalCost = totalCost + Math.min(paintHouse(costs, houseNumber+1, 1), paintHouse(costs, houseNumber+1, 2));
        }
        else if(color == 1) {
            totalCost = totalCost + Math.min(paintHouse(costs, houseNumber+1, 0), paintHouse(costs, houseNumber+1, 2));
        }
        else if(color == 2) {
            totalCost = totalCost + Math.min(paintHouse(costs, houseNumber+1, 0), paintHouse(costs, houseNumber+1, 1));
        }
        return dp[houseNumber][color] =  totalCost;
    }
                        
