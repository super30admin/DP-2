class Problem2 {

    // Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

    // The overall idea here is that for every combination will have 2 choices i.e either you pick a denomination or you don't
    // Each of them will lead to 2 more combinations of denomination and amount remaining. Our program further then keeps expanding the tree until amount = 0 or all coins are traversed
    // if we find a solution then we return 1. When we draw this recursive tree we find repeating sub problem and that indicates that we should go for DP solution.
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (j < coins[i - 1]) {
                    continue;
                } else {
                    dp[j] += dp[j - coins[i - 1]];
                }

            }
        }


        return dp[n];
    }

// for the below code
    // Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//     public int change(int amount, int[] coins) {
//         int m = coins.length;
//         int n = amount;
//         int[][] dp = new int[m + 1][n + 1];

//         for (int i = 0; i <= m; i++) {
//             dp[i][0]++;
//         }

//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {

//                 //System.out.println("Before i " + i + " j = " + j + " dp = " + dp[i][j]);
//                 if (j < coins[i - 1]) {
//                     dp[i][j] = dp[i - 1][j];
//                 } else {
//                     dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
//                 }

//                 //System.out.println("After i " + i + " j = " + j + " dp = " + dp[i][j]);
//             }
//         }

//         return dp[m][n];
//     }



//     public int change(int amount, int[] coins) {
//         if (coins == null) return -1;

//         return helper(coins, 0, amount);
//     }

//     private int helper(int[] coins, int index, int amount) {
//         // base condition
//         if (amount == 0) return 1;

//         if (amount < 0 || index >= coins.length) return 0;

//         // chooses
//         int case1 = helper(coins, index + 1, amount);

//         int case2 = helper(coins, index, amount - coins[index]);


//         return case1 + case2;
//     }
}