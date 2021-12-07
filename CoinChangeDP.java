/*
*Time an space complexity is O(nm)
Space complexity is also same
*/
class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return 0;
        int noOfCoins = coins.length;
        int[][] dp = new int[noOfCoins + 1][amount + 1];

        for (int i = 1; i < noOfCoins + 1; i++) {
            // if I have coin and I want to form any sum 0 I have 1 way
            dp[i][0] = 1;
        }

        for (int i = 1; i < noOfCoins + 1; i++) {
            int currentCoinVal = coins[i - 1];
            for (int j = 1; j< amount + 1; j++) {
                // so case where coin value is more than amount we can make it possible only by not sing that particular coin and that case is just above row
                if (j < currentCoinVal) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //case 0 is don't pick up coin which is one row above us and 2nd case is pick up the coin that is one 1 + as we are picking that coint and then current amount - coin amount
                    dp[i][j] = dp[i - 1][j]  + dp[i][j - currentCoinVal];
                }
            }
        }

        return dp[noOfCoins][amount];
    }
}
