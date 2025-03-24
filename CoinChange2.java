// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*

The dp[j] value represents the number of ways to form amount j.
We initialize dp[0] = 1 since there is one way to make amount 0 (by choosing no coins).
Then, for each coin, we iterate through the amounts and update dp[j] by adding the ways to
make j without the current coin (dp[j]) and with the current coin (dp[j - coins[i-1]]).
This optimizes space by reusing the same array, resulting in O(n) space complexity.
* */

class CoinChange2 {
    public int change(int amount, int[] coins) {


//1d array
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[n];
    }
}