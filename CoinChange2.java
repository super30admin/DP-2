// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class CoinChange {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        //Only one way, we can make amount '0' using coins 0,1,2,5
        for(int i=0; i<m+1; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                //If the amount is less than the coin value, assign the same value from the previous row
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    //assign the sum of values from the previous row same column and same row , previous column (column - coin) value
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        //last row last column contains the number of ways to form the amount
        return dp[m][n];
    }
}