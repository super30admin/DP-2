// Time Complexity : O(m*n) ,where m is length of coins array and n is amount given
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

class coinChange2 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0; // null case

        int m = coins.length, n = amount;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1; // filling first column with 1
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j) { // if denomination of coin is greater than amount to be made , then we will just
                                        // fill the cell with row above the current row
                    // zero case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // adding zero case and choose case to get all
                                                                       // possible ways
                    // choose case -> we need to take those many steps back equal to denomintaion of
                    // the coin
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1]; // returning last row and last column
    }
}