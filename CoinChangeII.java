public class CoinChangeII {
    //TC:O(n*amt) SC:O(amt)
    public int change(int amount, int[] coins) {
        // null case
        if(coins == null || coins.length == 0) return 0;
        int count  = 0;
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i < m+1; i++) {
            for(int j = 0; j < n+1; j++) {
                if(j >= coins[i-1]) {
                    dp[j] += dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}

// public int change(int amount, int[] coins) {
//         // null case
//         if(coins == null || coins.length == 0) return 0;
//         int count  = 0;
//         int m = coins.length;
//         int n = amount;
//         int[][] dp = new int[m+1][n+1];
//         dp[0][0] = 1;
//         for(int k = 1; k < n+1; k++ ) {
//             dp[0][k] = 0;
//         }
//         for(int i = 1; i < dp.length; i++) {
//             for(int j = 0; j < dp[0].length; j++) {
//                 // if amount< denomination then case 0 alone
//                 if(j < coins[i-1]) {
//                     dp[i][j] = dp[i-1][j];
//                 } else {
//                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
//                 }
//             }
//         }
//         return dp[m][n];
//     }

// exponential
// public int change(int amount, int[] coins) {
//         // null case
        
//         if(coins == null || coins.length == 0) return 0;
//         return helper(coins, amount, 0);

//     }

//     private int helper(int[] coins, int amount, int i) {
//         //base
//         if(amount == 0) return 1; // valid path
//         if(amount < 0 || i == coins.length) return 0;
//         //logic
//         //Case0: not choosing ele
//         int case0 = helper(coins, amount, i+1);
//         //Case1: choosing ele
//         int case1 = helper(coins, amount - coins[i], i);

//         return case0+case1;
//     }
