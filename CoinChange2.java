//DP

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount+1];
        
        for(int i = 0; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }
        
        for(int j = 1; j < amount+1; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount+1; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}

//Alternate DP approach without 2-D matrix, with just an array

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        
        dp[0] = 1;
        for(int j = 1; j < amount+1; j++){
            dp[j] = 0;
        }
        
       for(int i = 1; i < coins.length+1; i++){
           for(int j = 1; j < amount+1; j++){
               if(coins[i-1] <= j){
                   dp[j] += dp[j-coins[i-1]];
               }
           }
       }
        return dp[amount];
    }
}


//cleaning above approach

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        
        dp[0] = 1;
        
        for(int c : coins){
            for(int i = c; i < amount+1; i++){
                dp[i] += dp[i-c];
            }
        }
        
        return dp[amount];
    }
}
