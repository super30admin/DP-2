// Time complexity=O(n)
// Space complexity=O(7)

public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */

    public int minCost(int[][] costs) {
        // write your code here
        int[] dp = new int[costs.length];
        for(int i=0;i<costs[0].length;i++){
            dp[i]=0;
        }
        int dp0=0,dp1=0,dp2=0;
        for(int i==0;i<costs.length;i++){
             dp0=costs[i][0] + Math.min(dp1,dp2);
             dp1=costs[i][1] + Math.min(dp0,dp2);
             dp2=costs[i][2] + Math.min(dp1,dp0);
        }
        int min=dp0;
        for(inti=1;i<dp.length;i++){
            if(min>dp[i]) min=dp[i];
        }
        return min;
    }
}
