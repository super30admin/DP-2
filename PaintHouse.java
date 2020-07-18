// Time Complexity : O(2^n), n = number of houses 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//Brute Force

class Solution {
    public int minCost(int[][] costs) {
        int case0 = helper(costs, 0, 0, 0); //red
        int case1 = helper(costs, 0, 0, 1); //blue
        int case2 = helper(costs, 0, 0, 2); //green
        
        return Math.min(case0, Math.min(case1, case2));
    }
    
    public int helper(int[][] costs, int min, int row, int lastColour){
        if(row == costs.length) return min;
        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;
        
        //red
        if(lastColour==0)
         case1 = Math.min(helper(costs, min+costs[row][1], row+1, 1), //blue
                            helper(costs, min+costs[row][2], row+1, 2)); //green
        
        //blue
        if(lastColour==1)
         case2 = Math.min(helper(costs, min+costs[row][0], row+1, 0), //red
                            helper(costs, min+costs[row][2], row+1, 2)); //green
        
        //green
        if(lastColour==2)
         case3 = Math.min(helper(costs, min+costs[row][0], row+1, 0), //red
                            helper(costs, min+costs[row][1], row+1, 1)); //blue
        
        return Math.min(case1, Math.min(case2, case3));
        
        
    }
}



// Time Complexity : O(n), n = number of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// DP

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int[][] dp = new int[costs.length][3];
        for(int j = 0; j < 3; j++){
            dp[0][j] = costs[0][j];
        }
        
        for(int i = 1; i < costs.length; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[costs.length-1][0], Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
    }
}


class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        for(int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}
