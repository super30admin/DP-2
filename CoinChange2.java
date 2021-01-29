// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : figuring out the logic to populate the dp array

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        int rows = coins.length + 1;
        int cols = amount + 1;

        int dp[][] = new int[rows][cols];

        for(int i=0; i< rows; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i< cols; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                // if coin value is less than amount, take the value from previous row
                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                // else, add the value from previous row and (value from same row and (j- coin value) column)
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[rows-1][cols-1];

    }
}