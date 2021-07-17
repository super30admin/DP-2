class CoinChange2 {
    //time: O(nk) where n=num of coins, k=amount
    //space: O(nk)
    //Did it run successfully on leetcode: yes 
     public int change(int amount, int[] coins) {
         
         int[][] dp = new int[coins.length+1][amount+1];
         //num of ways to get 0 amount by using 0 coins is 1 i.e. by not selecting any coins
         //so we initialize it to 1
         dp[0][0] = 1;
         
         //looping through dp matrix
         for(int i=1; i<dp.length; i++){
             for(int j=0; j<dp[0].length; j++){
                 //if current coin is greater than the current amount
                 if(coins[i-1]>j){
                     //we don't pic any coin and take the old value of num of ways
                     dp[i][j] = dp[i-1][j];
                 }//if current coin is less than the current amount
                 else{
                     // we add the num of ways when we not select current coin and num of ways when we select current coin
                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                 }
            }
         }
        return dp[coins.length][amount];
    }
  
}