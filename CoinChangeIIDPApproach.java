// Time Complexity : O(m * n), where m = number of coins and n = amount
// Space Complexity : O(n), we use a 1D array of size amount+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// We use dynamic programming to count the number of combinations to form the given amount.
// We initialize a dp array where dp[j] represents the number of ways to make amount j.
// We iterate through each coin, and for each coin, we update dp[j] using the value at dp[j - coin].
// This captures two scenarios:
//   - "No Choose": We carry over the previous value in dp[j] (i.e., not using the current coin).
//   - "Choose": We add dp[j - coin], which represents the number of ways we could form (j - coin).
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        //DP 1D Array
        int[] dp = new int[n+1];

        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n ; j++) {
                if(coins[i-1] > j){
                    //no choose
                    dp[j] = dp[j];
                }else {
                    //no choose + choose
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}