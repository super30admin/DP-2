public class Problem2 {
    //We use bottom-up DP to count the number of ways to make up the target amount. Starting from the last coin, for each coin and amount, it adds combinations. dp[amount] will have the total number of ways to form the amount using all coins.
    ////TC is O(mxn) and SC is O(n) where n is the amount
    public int change(int amount, int[] coins) {
        int n = coins.length;
        long[] dp = new long[amount + 1]; // Use long to avoid overflow
        dp[0] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = coins[i]; j <= amount; j++)
                dp[j] += dp[j - coins[i]];
        }
        return dp[amount] <= Integer.MAX_VALUE ? (int) dp[amount] : -1;
    }
}
