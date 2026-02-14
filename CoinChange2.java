// Recursive O(2^(m+n)) time, O(m+n) space
// class Solution {
//     public int change(int amount, int[] coins) {
//         return helper(0, amount, coins);
//     }

//     public int helper(int i, int amount, int[] coins) {
//         if (i >= coins.length || amount < 0) return 0;

//         if (amount == 0) return 1;

//         int pick = helper(i, amount-coins[i], coins);
//         int dontPick = helper(i+1, amount, coins);

//         return pick + dontPick;
//     }
// }

// Bottom up DP O(n * amount) time, O(n * m) space
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n+1][amount+1];

//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = 1;
//         }

//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= amount; j++) {
//                 if (coins[i-1] <= j) { // can pick
//                     dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
//                 }
//                 else {
//                     dp[i][j] = dp[i-1][j];
//                 }
//             }
//         }
//         return dp[n][amount];
//     }
// }

// Bottom up DP space optimized O(n * amount) time, O(n) space
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i-1] <= j) { // can pick
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
                else {
                    dp[j] = dp[j]; // dont pick, its just current value
                }
            }
        }
        return dp[amount];
    }
}

