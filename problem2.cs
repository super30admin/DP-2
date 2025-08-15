public class Solution {
    public int minCost(int[,] costs) {
        var m = costs.Length;
        var n = costs[0].Length;
        int [,] dp = new int[m,n];
        dp[m-1,0] = costs[m-1,0];
        dp[m-1,1] = costs[m-1,1];
        dp[m-1,2] = costs[m-1,2];
        for(var i=m-2;i>=0;i--)
        {
            for(var j=0;j<n;j++)
            {
                 dp[i,0] = costs[i,0] + Math.Min(dp[i+1,1],dp[i+1,2]);
                 dp[i,1] = costs[i,1] + Math.Min(dp[i+1,0],dp[i+1,2]);
                 dp[i,2] = costs[i,2] + Math.Min(dp[i+1,0],dp[i+1,1]);
            }
        }
        return Math.Min(dp[0,0],Math.Min(dp[0,1],dp[0,2]))
    }
}