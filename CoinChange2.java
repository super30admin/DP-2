// Time Complexity :O(nm) number of coins times amount
// Space Complexity :O(mn)

/*
 * we are storing total possible ways we can get the amount 
 * using the given coins. we also include a dummy row and column 0.
 */

class CoinChange2{
    public int change(int amount, int[] coins) {
        if(coins.length == 0 || coins == null) return 0;
        
        int row = coins.length;
        int column = amount;
        int dp[][] = new int[row+1][column+1];
        dp[0][0] = 1;
        for(int i = 1; i <= column; i++) dp[0][i] = 0;
        
        for(int i = 1; i <= row; i++){
            for (int j = 0; j <= column; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[row][column];
    }
    
    
    /* // recursive solution (time limit exceded on leetcode)
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        
        return helper(coins, amount, 0);
    }
    
    public int helper(int[] coins, int amount, int idx){
        //base
        if(amount == 0) return 1;
        if(amount < 0 || idx == coins.length) return 0;
        //logic
        //choose
        int case1 = helper(coins, amount-coins[idx], idx);
        //dont choose
        int case2 = helper(coins, amount, idx+1);
        return case1+ case2;
    } */    
}