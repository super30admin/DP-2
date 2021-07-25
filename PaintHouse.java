// Time Complexity : O(3 * N) = O(N), Where N = Total houses.
// Space Complexity : O(3 * N) = O(N), Where N = Total houses.  + O(N) for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Cache
    private static int[][] memo;
    // DM for clean code
    private int[][] costs;
    
    public int minCost(int[][] costs) {
        
        // If theres no house, No cost is incured
        if(null == costs || costs.length == 0)
        {
            return 0;
        }
        
        this.costs = costs;
        // There are N houses which can be painted in 3 ways
        memo = new int[costs.length][3];
        
        for(int[] arr: memo)
        {
            Arrays.fill(arr, -1);
        }
        
        // We can start by painting 0th house as 0th colored
        int c1 = helper(0, 0);
        // Or We can start by painting 0th house as 1st colored
        int c2 = helper(1, 0);
        // Or We can start by painting 0th house as 3rd colored
        int c3 = helper(2, 0);
        
        // Answer will be min of all of the three 
        return Math.min(c1, Math.min(c2, c3));
    }
    
    private int helper(int prevCol, int ind)
    {
        // If all houses are painted. No cost is incurred anymore
        if(ind >= costs.length)
        {
            return 0;
        }
        
        // If result is already cached 
        if(memo[ind][prevCol] != -1)
        {
            return memo[ind][prevCol];
        }
        int minCost = (int)1e9;
        // Check what is the color used to paint the last house. 
        // Add its cost and try to paint next house by remaining two colors.
        // Get the costs and store the min of these in minCost
        if(prevCol == 0)
        {
            int c1 = costs[ind][0] + helper(1, ind + 1);
            int c2 = costs[ind][0] + helper(2, ind + 1);
            minCost = Math.min(c1, c2);
        }
        else if(prevCol == 1)
        {
            int c1 = costs[ind][1] + helper(0, ind + 1);
            int c2 = costs[ind][1] + helper(2, ind + 1);
            minCost = Math.min(c1, c2);
        }
        else
        {
            int c1 = costs[ind][2] + helper(0, ind + 1);
            int c2 = costs[ind][2] + helper(1, ind + 1);
            minCost = Math.min(c1, c2);
        }
        // Add to Cache and return
        memo[ind][prevCol] = minCost;
        return minCost;
    }
    
}