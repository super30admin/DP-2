// Time Complexity : O(rows*cols)
// Space Complexity : O(rows*cols)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:

/**
 * Went exhaustive but by memorizing the pre-calculated solutions for same
 * sub-problems into a matrix.
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int rows = coins.length;
        int cols = amount;

        int[][] dp = new int[rows+1][cols+1];
        dp[0][0] = 1;

        for(int i=1; i<=rows; i++) {
            for(int j=0; j<=cols; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[rows][cols];
    }
}
