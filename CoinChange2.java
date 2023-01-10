// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We see a repeated subproblem pattern so we create use a dp matrix approach.
// For dp[m][n] will give us the number of ways we can form the amount.


class Solution {
    public int change(int amount, int[] coins) {
        
        if(coins == null) return 0;

    
    int m=coins.length;int n=amount;
    int[][]dp = new int[m+1][n+1];
    
    //fill the first column with 1;
    for(int i=0;i<=m;i++){
        dp[i][0]=1;
    }
    
    for(int i=1;i<=m;i++){ //i=0 is dummy
        for(int j=1;j<=n;j++){
            if(j<coins[i-1]){
                dp[i][j]=dp[i-1][j];
            } else {
                dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
    }
    return dp[m][n];
    }
}