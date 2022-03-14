// Time Complexity : O(mn) n = amount , m = no of coins
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
APPROACH 1: Brute force exhaustive solution by checking for all the possible solutions resulted due to choosing and not choosing a coin.
APPROACH 2: using the DP array with size of (kinds of coins + 1)x(amount + 1)
dp[i][j] = dp[i-1][j] // not choosing the coin + dp[i][j - coins[i-1]] // choosing the coin
 */

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount + 1];

        if(amount == 0) return 1;
        if(coins.length == 0) return 0;

        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = 0;
        }
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1]>j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[dp.length-1][dp[0].length - 1];
    }
}
