//Time Complexity - O(m * n) m is the number of coins and n is amount
//Space Complexity - O(m * n)

// Implemented using Dynamic programming as the exhaustive search leads to timeout. Taken a 2D array
//where rows are the coins and columns are the amount. the value is determined when from top value directly above
// if amount is less than coin else determined by Min of top value and the value at the previous coins
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 1; i < amount + 1; i++) {
            dp[i][0] = 1;
        }
        for(int i =1; i< coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
