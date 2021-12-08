class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length == 0)
        {
            return 0;
        }
        
        int[][] dp = new int[costs.length][3];
        int n = costs.length;
        
        for(int i=0;i<3;i++)
        {
            dp[n-1][i]=costs[n-1][i];
        }
        
        for(int i=n-2;i>=0;i--)
        {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1],dp[i+1][0]);
        }
        
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
        
    }
}