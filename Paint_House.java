/**
 * 2 different methods, 1st - recursive and 2nd DP
 */
// Time Complexity : Exponential: O(3*2^n) where n is the number of costs.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes (little tricky)
// Any problem you faced while coding this : yes(little tricky)


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        int case1 = helper(costs,0,0,0);    // if red is chosen
        int case2 = helper(costs,0,0,1);    //if green is chosen
        int case3 = helper(costs,0,0,2);    // if blue is chosen
        return Math.min(case1,Math.min(case2,case3));
    }
    private int helper(int[][] costs, int min, int row, int lastColor){
        //base approach
        if(row == costs.length)
            return min;
        int case1 = Integer.MAX_VALUE,case2 = Integer.MAX_VALUE;
        // if lastcolor  was 0, then choose the other values for the next house and FIND THE MINIMUM and return
        if(lastColor == 0){
            case1 = helper(costs,min+costs[row][lastColor],row+1,1);
            case2= helper(costs,min+costs[row][lastColor],row+1,2);
        }
        if(lastColor == 1){
            case1 = helper(costs,min+costs[row][lastColor],row+1,0);
            case2= helper(costs,min+costs[row][lastColor],row+1,2);
        }
        if(lastColor == 2){
            case1 = helper(costs,min+costs[row][lastColor],row+1,0);
            case2= helper(costs,min+costs[row][lastColor],row+1,1);
        }
        return Math.min(case1,case2);
    }
}

// Time Complexity : Exponential: O(n) where n is the number of costs.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes(little tricky)

/**
 * Using the given matrix as the dp matrix(storage and reusage),
 *  for each cell in the matrix, find the most suitable previous row cell(Min of possible colors cost) and add it to the current cell
 *  return the min of the last row (since each cell in last row contains the min cost to paint all houses if we chose that cell color)
 */
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        for(int i=1;i<costs.length;i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(costs[costs.length-1][0],
                Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}