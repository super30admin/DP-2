
class Solution{
    public int coinChange(int amount, int[] coins){
        if(coins == null || coins.length == 0) return 0;
        //row of the DP matrix
        int n = amount;
        int m = coins.length;//error: cannot find symbol [in __Driver__.java]

        int[][] dp = new int[m + 1][n + 1];

        for(int i =0; i < m+1; i++){
            dp[i][0] = 1;
        }


        for(int i =1; i<m+1; i++){
            for(int j =1; j<n+1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }


        return dp[m][n];
    }
}





// error is Time Limit Exceeded

// class Solution {
//     public int change(int amount, int[] coins) {
//         if(coins == null || coins.length == 0) return 0;

//         return helper(amount, coins, 0);
//     }
//     private int helper(int amount, int[] coins, int index){
//         // base case
//         if(index == coins.length || amount < 0){
//             return 0;
//         }
//         if(amount == 0){
//             return 1;
//         }

//         //logic
//         int case1 = helper(amount, coins, index+1);
//         int case2 = helper(amount-coins[index], coins, index);
//         return case1 + case2;
//     }
// }