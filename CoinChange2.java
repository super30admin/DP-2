class Solution {
    // TC - O(m*n)
    // SC - O(m)
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;

        int[] dp = new int[m + 1];
        // initalize to 1 since amount 0 can be made up always
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
           for (int j = 0; j <= m; j++) {
                if (j >= coins[i - 1]) {
                    // adding up the number of ways we can compute amount
                    // case 1 is not including the current denomination and case 2 
                    // is choose current denomination
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
                
            } 
        }

        return dp[m];
    }
}