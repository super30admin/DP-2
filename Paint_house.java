// Time Complexity : O(m*k*k)
// Space Complexity : O(m*k)
// Did this code successfully run on Leetcode : yes
class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[m][k];
        for(int i=0; i<k; i++){
            dp[m-1][i] = costs[m-1][i];
        }
        
        for(int i= m-2; i>=0; i--){
            for(int j=0; j<k;j++){
                int min = Integer.MAX_VALUE;
                for(int next=0;next<k;next++){
                    if(next!=j){
                        min = Math.min(min,dp[i+1][next]);
                    }
                }
                dp[i][j]= costs[i][j]+min;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            res= Math.min(res,dp[0][j]);
        }
        return res;
    }
}
