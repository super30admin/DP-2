// Time Complexity : O(N) or O(n*3) where n are houses and 3 is colors
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public int minCost(int[][] costs) {
    int m = costs.length;
    int n=3;
    int[][] dp = new int[m][n];
    
    for(int i=0;i<n;i++){
        dp[m-1][i]=costs[m-1][i];
    }
    
    for(int i=m-2;i>=0;i--){
        for(int j=0;j<n;j++){
            if(j==0){
                dp[i][j]=costs[i][j] + Math.min(dp[i+1][j+1],dp[i+1][j+2]);
            }else if(j==1){
                dp[i][j] = costs[i][j] + Math.min(dp[i+1][j-1],dp[i+1][j+1]);
            }else{
                dp[i][j] = costs[i][j] + Math.min(dp[i+1][j-1],dp[i+1][j-2]);
            }
        }
    }
    return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
}