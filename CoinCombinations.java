// Time Complexity : O(n^2)), 
// Space Complexity : O(n), where n is size of dp
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package dp2;

public class CoinCombinations {
     public int change(int amount, int[] coins) {
        //check length
        if (coins.length == 0 || coins == null) {
            return 0;
        }
        int dp[][] = new int [coins.length +1] [amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //when amount is less than denomination coin used
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //add two
                    dp[i][j] =dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[dp.length -1][dp[0].length -1]; 
    }
}
