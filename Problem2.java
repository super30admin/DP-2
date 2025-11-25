// Time Complexity : O(M*N)
// Space Complexity : O(M*N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Initally took the dp array of m+1 and n+1
Took the amount on the columns whereas took the coins on rows.
In each iteration, if the denomination of the coin is greater than the current amount, then performed the below calculation
Added the sum from the row above and from [i][j-coins[i-1]] position
*/

public class Problem2 {
    public int change(int amount, int[] coins) {
        if(coins.length == 0) {
            return 0;
        }
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i = 1;i<=m;i++) {
            for(int j = 0;j<=n;j++) {
                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}
