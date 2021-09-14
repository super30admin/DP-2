// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Coin Change-2


class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length + 1][amount + 1];
        //first col
        for(int i = 0; i < dp.length;i++){
            dp[i][0]=1;

        }
        for(int i = 1; i<dp.length; i++){
            for (int j = 1; j<dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }

            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    // Time Complexity : o(m)
// Space Complexity : o(1)
    public int minCost(int [][] costs){
        if(costs == null || costs.length==0){
            return 0;
        }
        for(int i = costs.length-2; i >= 0; i-- ){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][1], costs[i+1][0]);
        }
        return Math.min(costs[0][1],Math.min(costs[0][0],costs[0][2]));
    }
}