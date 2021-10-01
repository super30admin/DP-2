// Time Complexity : O(n * m) n= numbers of coins and m = number of amount
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        int n=coins.length +1;
        int m = amount +1;
        
        int[][] dp=new int[n][m];
        // this is important to understand what should be init condition
        for(int i=1;i<m;i++){
            dp[0][i]=0;
        }
        
         for(int j=0;j<n;j++){
            dp[j][0]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j < coins[i-1]){
                    dp[i][j] =  dp[i-1][j];
                } else {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}