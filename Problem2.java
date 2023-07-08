// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// this problem is solved using dp matrix, is created with using value from the above row in the same column + same row that many steps backword.
// last row last column give the total number of ways.

class Solution {
    public int change(int amount, int[] coins) {
        int m=amount;
        int n=coins.length;
        int dp[][] = new int[n+1][m+1];
        dp[0][0]=1;
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<= n;i++){
            for(int j=1;j<= m;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][m];
    }
}