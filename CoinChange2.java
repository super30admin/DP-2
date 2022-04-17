public class CoinChange2 {
    // Time complexity: O(m * n) -> m is coins.length   n is amount
    // Space complexity: O(m * n)
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        // There is an only way of making amount 0 which is do not pick this denomination
        for(int i=0; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }

        // Now populating the matrix starts here
        for(int i=1; i < coins.length + 1; i++) {
            for(int j=1; j < amount+1; j++) {
                // If the target amount to achieve is less than the denomination we are currently considering then
                    // simply copy the values from the previous row
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i -1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i -1]];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
