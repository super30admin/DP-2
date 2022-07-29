// Time Complexity : O(mn)
// Space Complexity : O(n) for the extra dp array we use
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    public int minCost(int[][] costs) {
        int n=costs.length;
        if(costs==null || costs.length==0) return -1;
        int dp[][]=new int [n][3];
        for(int j=0; j < 3;j++){
            dp[n-1][j]=costs[n-1][j]; //initialize last row of the dp matrix
        }
        for(int i=n-2;i>=0;i--){
            //calculate dp[i] for every red element in the row i as the sum of cost of the 
            //current red and minimum cost of G or B in the previous row
            dp[i][0]=costs[i][0]+Math.min(dp[i+1][1], dp[i+1][2]);
            //similar for green and blue elements of each row i
            dp[i][1]=costs[i][1]+Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
  
}