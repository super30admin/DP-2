class Solution {
    //Time O(N)
    //Space O(N)
    public int minCost(int[][] costs) {
       if(costs == null || costs.length == 0)
       {
           return 0;
       }
       int[][] dp = new int[costs.length][3];
       int n = dp.length-1;
       dp[n][0] = costs[n][0] ; dp[n][1] = costs[n][1]; dp[n][2] = costs[n][2];
       for(int i = dp.length-2 ; i>=0 ; i--)
       {
           for(int j=0 ; j<dp[0].length ; j++)
           {
               if(j == 0)
               {
                   dp[i][j] = costs[i][j] + Math.min(dp[i+1][j+1] , dp[i+1][j+2]);
               }
               else if(j == 1)
               {
                   dp[i][j] = costs[i][j] + Math.min(dp[i+1][j-1] , dp[i+1][j+1]);
               }
               else
               {
                   dp[i][j] = costs[i][j] + Math.min(dp[i+1][j-1] , dp[i+1][j-2]);
               }
           }
       }
        int result = Math.min(dp[0][0] , Math.min(dp[0][1] , dp[0][2]));
        return result;
    }
}