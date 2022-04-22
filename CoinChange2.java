// Time complexity: O(m*n) where m is the number of coins and n is the amount.
// Space complexity: O(m*n) where m is the number of coins and n is the amount.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        int dp[][] = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;       // Amount is 0. Only way to get this is to not select any coin.
        }
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];    // If amount is less than coin, get the no. of ways from above row.
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];    // Total ways is at the last row and last column.
    }  
}


// Brute force method / Exhaustive
// public int change(int amount, int[] coins) {
//         if(coins == null || coins.length == 0) return 0;
//         return helper(coins, amount, 0);
//     }
    
//     private int helper(int[] coins, int amount, int index) {
//         //base
//         if(amount == 0) return 1;
//         if(amount < 0 || index == coins.length) return 0;
//         //logic
//         // Do not pick current index.
//         int case1 = helper(coins, amount, index + 1);
//         // Picked the current index.
//         int case2 = helper(coins, amount - coins[index], index);
//         return case1 + case2;
//     }