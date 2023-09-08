/*

Problem1(https://leetcode.com/problems/paint-house/)

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA


 */


 // Approach Using DP

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null){
            return 0;
        }

        int n = costs.length;

        for(int i = n-2; i >= 0 ; i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][1], costs[i+1][0]);
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));

    }

}

// Approach using recursive

//Time Complexity : O(2^(n))
//Space Complexity : O(1)

class Solution_1 {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null){
            return 0;
        }

        int costRed = recurse(costs, 0, 0, 0);
        int costBlue = recurse(costs, 1, 0, 0);
        int costGreen = recurse(costs, 2, 0, 0);

        return Math.min(costRed,Math.min(costBlue, costGreen));
    }

    private int recurse(int[][] costs, int column, int row, int sum){

        if(row == costs.length){
            return sum;
        }

        if(column == 0){
            return Math.min(recurse(costs, 1, row + 1, sum + costs[row][column]), 
            recurse(costs, 2, row + 1, sum + costs[row][column]));
        }

        if(column == 1){
            return Math.min(recurse(costs, 0, row + 1, sum + costs[row][column]), 
            recurse(costs, 2, row + 1, sum + costs[row][column]));
        }

        if(column == 2){
            return Math.min(recurse(costs, 0, row + 1, sum + costs[row][column]), 
            recurse(costs, 1, row + 1, sum + costs[row][column]));
        }

        return 5454454;
    }

}