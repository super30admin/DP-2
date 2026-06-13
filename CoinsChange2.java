// Time complexity: O(m*n) m is number of rows and n is number of columns
// Spcae complexity:  O(m*n)
// We build a 2D DP table where dp[i][j] is the number of  combinations to make amount j using first i coins.
// If we can't pick the current coin, we just use the value from the row above.


class CoinChange2 {
    public int change(int amount, int[] coins) {
        int rows = coins.length;
        int columns = amount;
        // declare a 2-D Array to capture the values of no of coins for a given amount
        int[][] dp = new int[rows+1][columns+1];
        // we treat this as 1 case because the amount needed is 0 and is valid path.
        dp[0][0] = 1;
        // fill the remaining rows and clolumns of the table
        for (int row =1; row<=rows; row++) {
            for (int column=0; column<=columns; column++) {
                if (column < coins[row - 1]) { // denomination > amount case 0
                    dp[row][column] = dp[row - 1][column];
                } else {
                    // 0 case + 1 case
                    dp[row][column] = dp[row - 1][column] + dp[row][column - coins[row - 1]];
                }
            }
        }
        return dp[rows][columns];
    }
}