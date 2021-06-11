// Recursive Solution

// Time Complexity : 3x2^N where N is the lenght of the matrix
// Space Complexity : Same
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<3; i++){
            min = Math.min(min, helper(costs, 0, i, 0));
        }
        return min;
    }
    
    private int helper(int[][]costs, int row, int col, int sum){
        //base
        if(row >= costs.length)
            return sum;
        
        
        //logic
        if(col == 0){
            return Math.min(helper(costs, row+1, 1, sum + costs[row][col]),
                            helper(costs, row+1, 2, sum + costs[row][col]));
        }
        
        if(col == 1){
            return Math.min(helper(costs, row+1, 0, sum + costs[row][col]),
                            helper(costs, row+1, 2, sum + costs[row][col]));
        }
        
        if(col == 2){
            return Math.min(helper(costs, row+1, 0, sum + costs[row][col]),
                            helper(costs, row+1, 1, sum + costs[row][col]));
        }
        return Integer.MAX_VALUE;
    }
}

// DP Solution

// Time Complexity : O(3xN) = O(N) where N is the length of the matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        for(int i = costs.length - 2; i>= 0; i--){
          // self + min of the other 2 columns
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
