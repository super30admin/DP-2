// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we mutate the same matrix we keep the bottom row as it is. And for the rows above we choose one of the color
//and we find the minumum of the other two in the below row and add it with the current cost. We do this for all the three colors and all the rows.
//Finally we return the minimum of the first row which will be our minimum cost.

public class PaintHouse {
    
    public int minCost(int[][] costs) {

        if(costs == null || costs.length== 0)return 0;
        int n = costs.length;
        
        for(int i=n-2;i>=0;i--){
            costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0],costs[i+1][1]);
        }

        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
class PaintHouse2{
    
    public int minCost(int[][] costs) {

        if(costs == null || costs.length== 0)return 0;
        int n = costs.length;

        int [][] dp = new int[n][3];
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];
        
        for(int i=n-2;i>=0;i--){
            dp[i][0] = costs[i][0]+ Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1] = costs[i][1]+ Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2] = costs[i][2]+ Math.min(dp[i+1][0],dp[i+1][1]);
        }

        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
class PaintHouse3{
    
    public int minCost(int[][] costs) {

        if(costs == null || costs.length== 0)return 0;
        int n = costs.length;

        int [] dp = new int[3];
        int varR= costs[n-1][0];
        int varB = costs[n-1][1];
        int varG = costs[n-1][2];
        
        for(int i=n-2;i>=0;i--){
            int tempR = varR;
            varR = costs[i][0]+ Math.min(varB,varG);
            int tempB = varB;
            varB = costs[i][1]+ Math.min(tempR,varG);
            varG = costs[i][2]+ Math.min(tempR,tempB);
        }

        return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }
}

// Time Complexity : O(2^n)
//Recursive solution
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length== 0)return 0;
        int costR = helper(costs,0,0,0);
        int costB = helper(costs,0,1,0);
        int costG = helper(costs,0,2,0);

        return Math.min(costR,Math.min(costB,costG));
    }

    private int helper(int[][] costs, int idx, int color, int minCost){
        //base
        if(idx == costs.length)return minCost;
        //logic

        if(color == 0){
            return Math.min(helper(costs, idx+1, 1, minCost + costs[idx][0]),helper(costs, idx+1, 2, minCost + costs[idx][0]));
        }
        if(color == 1){
            return Math.min(helper(costs, idx+1, 0, minCost + costs[idx][1]),helper(costs, idx+1, 2, minCost + costs[idx][1]));
        }
        if(color == 2){
            return Math.min(helper(costs, idx+1, 0, minCost + costs[idx][2]),helper(costs, idx+1, 1, minCost + costs[idx][2]));
        }
        return 324;
    }
}