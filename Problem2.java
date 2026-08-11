// Coin CHange 2
// time complexity : O(mxn)
//space complexity: o(mxn)
Every matrix index assingin number of values  and for line 25 we can see a repitive problem and add those instead of calculating number of combination again

class Solution {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {

                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] 
                             + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }
}