Brute Force : 



class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0) return 0;
        return helper(coins,0,amount);
    }

    private int helper(int[] coins, int idx, int amount){
        //base

         if(amount == 0) return 1;
         if(idx==coins.length || amount < 0) return 0;
        //choose
        int case1 = helper(coins, idx, amount-coins[idx]);
        //notchoose
        int case2 = helper(coins, idx+1, amount);
         return case1+case2;
        
    }
}                              


/**
 * 
 * Here we have to find all possible coins that are forming the amount. So going in an exhaustive way.
    Why does an exhaustive solution have TC - exponential (2^n)? → bcz every node in a tree has 2 choices (choose, notchoose).

 * 
 * 
 */



class Solution {
    public int change(int amount, int[] coins) {
       if (coins == null || coins.length == 0) {
            return amount == 0 ? 1 : 0;
        }
        
        int n = amount;
        int m = coins.length;
        
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        
     
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}





/**
TC : O(m*n)
SC : O(m*n)


Description : Creating a 2D matrix, in the 0th index initally adding 1 bcz we have to return number opf ways. 
            comparing "j<Coins[i-1]", if j is less than perticular coin, we can put same value as "dp[i][j] = dp[i-1][j]"
            otherwise adding above element "dp[i-1][j]" with amount back with current coin "dp[i-1][j]"



 */