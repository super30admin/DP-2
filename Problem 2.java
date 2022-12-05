// Time Complexity : O (row * columns), where rows are rows in costs and columns are columns in costs
// Space Complexity :O (columns) , where rows are rows in costs and columns are columns in costs
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : The generation of 0/base case was difficult


// Your code here along with comments explaining your approach
/*
We will break the problem into the smallest subproblem , suppose that we have only first row available, then 
each col is already at the minimum, as we took minimum from previous row (for start we would have dummy row for 0 values)
then we increase the number of rows and consider next rows values compared with prev and build our table
the last row would have the minimums, so we will take the minimum of all columns of the last row;
*/
class Solution {
    public int minCost(int[][] costs) {
        // We need only one row at a time, so we would use this array for previous values, as reference to the current can be get from the costs array
        int[] dp = new int[costs[0].length]; 
        // the first row is already filled with 0s

        // we will solve the smallest sub problem first and then increase our options
        for(int row =1;row<=costs.length;row++){
            int prev0=0,prev1=0; // temporary variables to hold values bcus we have to deal with only array to optimize space
            for(int col=0;col<costs[0].length;col++){
                // when we choose a color, then we have to take values other than that color from the prev row plus the current color values
                if(col ==0){
                    prev0 = dp[0]; // since we will be mutatin it so saving its state for furture
                    dp[col]  = costs[row-1][col] + Math.min(dp[1],dp[2]);
                }
                if(col == 1){
                    prev1 = dp[1];// since we will be mutatin it so saving its state for furture
                    dp[col]  = costs[row-1][col] + Math.min(prev0,dp[2]);
                }
                if(col == 2){
                    dp[col]  = costs[row-1][col] + Math.min(prev0,prev1);
                }
            }
        }

        // At the last row , we will have the minimum for each color

        // so we need to return the minimum from those colors

        return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }

}