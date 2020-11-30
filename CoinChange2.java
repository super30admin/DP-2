//TC :- O(mn)
//SC :- O(mn)
class CoinChange2 {
    public int change(int amount, int[] coins) {
        // if(coins == null)
        //     return 0;
        // return helper(coins, amount, 0);
        if(coins == null) {
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        int m = dp.length, n = dp[0].length;
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j]  = dp[i - 1][j];
                }  else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    
//     private int helper(int[] coins, int amount, int index) {
//         if(amount == 0)
//             return 1;
//         if(amount < 0 || index == coins.length)
//             return 0;
//          //logic
//         //choose
//         int case1 = helper(coins, amount - coins[index], index);
//         //dont choose 
//           int case2 = helper(coins, amount, index + 1);
        
//          return case1 + case2;
//     }
}