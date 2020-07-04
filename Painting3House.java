class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int dp [][] = new int[n][3];
        
        //edge
        if(costs == null || costs.length == 0) return 0;
        
        //populate first row
        for(int i = 0;i< 3 ;i++){
            dp[0][i] = costs[0][i];
        }
        
        for(int i = 1; i< n;i++){
            //red
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            //green
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            //blue
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0] ,dp[i-1][1]);    
        }
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
}

/*
TimeComplexity O(m x n)  here m is no of colors and n is no of houses ie O(3 x pow(2,n)) 
SpaceCompexity O(m x n) dp map made
*/