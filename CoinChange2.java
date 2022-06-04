// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange2 {

    // time and space complexity is O(mxn)
    public int change(int amount, int[] coins) {
        if (coins.length == 0 || coins == null)
            return 0; // check the null case

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[m][n];
    }

    /*//exhaustive method
     * public int change(int amount, int[] coins) {
     * return helper(coins, amount, 0);
     * }
     * 
     * private int helper(int[] coins, int amount, int i){
     * //base
     * if(amount == 0) return 1;
     * if(amount <0 || i == coins.length) return 0;
     * 
     * //logic
     * //not choose
     * int case1 = helper(coins, amount, i+1);
     * //choosing that index
     * int case2 = helper(coins, amount-coins[i], i);
     * return case1 + case2;
     * }
     */
}