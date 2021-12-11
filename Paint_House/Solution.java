// Time Complexity : O(n) --> as each house has only 3 values so colmns is constant
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * For each house starting from 1, we check what will be the min cost we choose to go with red, blue and green color. 
 * For each color in current house, we take min between costs required to color prev house with other 2 colors.
 * This way in last row, we get 3 costs and we take min between them.
*/

class Solution {
    public int minCost(int[][] costs) {
//         int[][] dp = new int[costs.length + 1][3];
//         dp[0][0] = 0;
//         dp[0][1] = 0;
//         dp[0][2] = 0;
        
//         for(int r = 1; r < dp.length;r++){
//             dp[r][0] = costs[r-1][0] + Math.min(dp[r-1][1], dp[r-1][2]);
//             dp[r][1] = costs[r-1][1] + Math.min(dp[r-1][0], dp[r-1][2]);
//             dp[r][2] = costs[r-1][2] + Math.min(dp[r-1][0], dp[r-1][1]);
//         }
        
//          return Math.min(Math.min(dp[dp.length-1][0], dp[dp.length-1][1]), dp[dp.length-1][2]);
        
        
        for(int r = 1; r < costs.length;r++){
            costs[r][0] = costs[r][0] + Math.min(costs[r-1][1], costs[r-1][2]);
            costs[r][1] = costs[r][1] + Math.min(costs[r-1][0], costs[r-1][2]);
            costs[r][2] = costs[r][2] + Math.min(costs[r-1][1], costs[r-1][0]);
        }
        
        return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
    }
    
    private int cal(int[][] costs, int row, int prev, int cost){
        //base case
        if(row == costs.length)return cost;   
        
        
        //logic
        int case1=Integer.MAX_VALUE, case2 = Integer.MAX_VALUE, case3 = Integer.MAX_VALUE;
       if(prev != 0) case1 = cal(costs, row+1, 0, cost + costs[row][0]);
        
        if(prev != 1)case2 = cal(costs, row+1, 1 , cost + costs[row][1]);
        
        if(prev != 2)case3 = cal(costs, row+1, 2, cost + costs[row][2]);
        
        
        return Math.min(Math.min(case1, case2), case3);
    }
}