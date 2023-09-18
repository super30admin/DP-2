// Time Complexity :  O(n)
// Space Complexity :  O(1) - mutated the matrix
// Did this code successfully run on Leetcode :  Yes https://leetcode.com/problems/paint-house/submissions/1052265765/
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach

// Exhaustive approach

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int costRed = recurse(costs, 0, 0, 0);
        int costBlue = recurse(costs, 1, 0, 0);
        int costGreen = recurse(costs, 2, 0, 0);
        return Math.min(costRed, Math.min(costBlue, costGreen));
    }
    private int recurse(int[][] costs, int color, int row, int totalCost){
        if(row == costs.length){
            return totalCost;
        }
        if(color ==0){
            return Math.min(recurse(costs, 1, row+1, totalCost+costs[row][color]), recurse(costs, 2, row+1, totalCost+costs[row][color]));
        }
        if(color == 1){
            return Math.min(recurse(costs, 0, row+1, totalCost + costs[row][color]) , recurse(costs,2, row+1, totalCost +costs[row][color]));
        }
        if(color ==2){
            return Math.min(recurse(costs, 0, row+1, totalCost +costs[row][color]), recurse(costs,1, row+1, totalCost+costs[row][color]));
        }
        return -1;
    }
}

//https://leetcode.com/problems/paint-house/submissions/1052265765/
/*
 * If you try exhaustive approach for each color, and add the minimum cost each time, it gives the min cost to pain house, but results in exponential time complexity due to repeated subproblems
 * So inorder to solve the above issue, we use bottom approach, where we find the min of other 2 houses in the last row and then add it to the left out row value in the above row
 * This leaves out the first row minimum costs to paint for each color
 */
class Solution1 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        for(int i= n-2; i>=0; i--){
            costs[i][0] = costs[i][0]+ Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1],  costs[0][2]));
    }
}

