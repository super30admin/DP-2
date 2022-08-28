// Time Complexity : O(m*n) m is the coins and n is the amount
// Space Complexity : O(N) created a new 2d array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Problem2 {

    public int change(int amount, int[] coins) {
    //null check
        if(coins == null || coins.length ==0) return 0;

    int m = coins.length;
    int n = amount;

    //dp array
    //taking m+1 and n+1 as we are starting from zero
    int dp[][] = new int[m+1][n+1];

    //case when we have 0 coins and 0 amount
    dp[0][0] = 1;

    //two loops
    //first goes till the possible coins
    //second goes till the possible amount
        for(int i=1; i<=m; i++){
        for(int j=0; j<=n; j++){

            //case till the amount is less than the value of coin we have
            if(j<coins[i-1]){
                dp[i][j] = dp[i-1][j];
            }
            else{
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }

        }

    }

    //not returning m+1 and n+1 as we took a dummy row
     return dp[m][n];
}
}
