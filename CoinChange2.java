// class Solution {
//     public int change(int amount, int[] coins) {
        
//         return helper(coins, amount, 0);
//     }
    
//     private int helper(int[] coins, int amount, int index){
//         //base
//         if(coins.length == index || amount < 0)
//             return 0;
//         if(amount == 0)
//             return 1;
    
//         //logic
//         int case1 = helper(coins, amount, index + 1);
//         int case2 = helper(coins, amount - coins[index], index);
        
//         return case1+case2;
//     }
// }



class Solution {
    public int change(int amount, int[] coins) {
        
        int m  = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i < m+1; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if( j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[m][n];
    }
}