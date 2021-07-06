// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution{
    public int minCost(int[][] costs){
        //base case to check if the array is empty
       if(costs == null || costs.length == 0){
           return 0;
       } 

       //costs, row, col, minCost
       int case1 = helper(costs, 0, 0, 0);
       int case2 = helper(costs, 0, 1, 0);
       int case3 = helper(costs, 0, 2, 0);


       return Math.min(case1, Math.min(case2, case3));

    }

    private int helper(int[][] costs, int row, int color, int min){
        //base
        if(row == costs.length)
            return min;

        //logic
        //if the chosen color is at position 0, then we need to pick from the other two options
        if(color == 0){
            return Math.min(
                helper(costs, row + 1, 1, min + costs[row][color]),
                helper(costs, row + 1, 2, min + costs[row][color])
            );
        }
        //since color is 1, we can choose the min from 0 or 2
        else if(color == 1){
            return Math.min(
                helper(costs, row + 1, 0, min + costs[row][color]),
                helper(costs, row + 1, 2, min + costs[row][color])
            );
        }
        //color is 2 so we choose between 0 and 1
        else{
            return Math.min(
                helper(costs, row + 1, 1, min + costs[row][color]),
                helper(costs, row + 1, 0, min + costs[row][color])
            );
        }
    }
}