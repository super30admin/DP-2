// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution{
    public int minCost(int[][] costs){
        if (costs.length == 0 || costs == null) return 0;
        int[][] dp = new int[costs.length][3];
        for(int j=0; j<3; j++){
            dp[dp.length-1][j] = costs[costs.length-1][j];
        }
        for(int i= cost.length-2; i>=0; i--){
            costs[i][0] = costs[i][0] + Math.mindp[i+1][1], dp[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

/*
* // exhaustive approach:
class Solution{
  public int minCost(int[][]costs){
     if(costs == null || costs.length == 0) return 0;
//color of first house : red
     int case1 = helper(costs, 0, 0, 0);
//color of first house : blue
     int case2 = helper(costs, 0, 1, 0);
//color of first house : green
     int case3 = helper(costs, 0, 2, 0);
     return Math.min(case1, Math.min(case2, case3));
  }
  private int helper(int[][] costs, int row, int currColor, int minCost){
     // base
     if(row == costs.length) return minCost;

     //logic
     if(currColor == 0){
	return Math.min(
      helper(costs, row+1, 1, minCost + costs[row][0]),
      helper(costs, row+1, 2, minCost + costs[row][0])
        );
     }
     if(currColor == 1){
	return Math.min(
      helper(costs, row+1, 0, minCost + costs[row][1]),
      helper(costs, row+1, 2, minCost + costs[row][1])
        );
     }
     if(currColor == 2){
	return Math.min(
      helper(costs, row+1, 1, minCost + costs[row][2]),
      helper(costs, row+1, 0, minCost + costs[row][2])
        );
      }
    return 0;
   }
}
* */