// 256. Paint House - https://leetcode.com/problems/paint-house/
// Time Complexity : O(2^N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution{
    public int minCost(int[][] costs){
        if(costs == null || coins.length == 0)    
            return 0;

        //coins, row, column, minCost
        int case1 = helper(costs,0,0,0);
        int case2 = helper(costs,0,1,0);
        int case3 = helper(costs,0,2,0);

        return Math.min(case1. Math.min(case2,case3));
    }

    private int helper(int[][] costs, int row, int cloumn, int minCost)
    {
        // base
        if(row==costs.length) return minCost;

        if(color == 0)
        {
            return Math.min(
                helper(costs, row+1, 1, minCost + costs[row][0]), 
                helper(costs, row+1, 2, minCost + costs[row][0])
                );
        }
        else if(color == 1)
        {
            return Math.min(
                helper(costs, row+1, 0, minCost + costs[row][1]), 
                helper(costs, row+1, 2, minCost + costs[row][1])
                );
        }
        else
        {
            return Math.min(
                helper(costs, row+1, 1, minCost + costs[row][2]), 
                helper(costs, row+1, 0, minCost + costs[row][2])
                );
        }
    }
}