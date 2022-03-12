class CoinChange2 {
  /**
   * 
   * 
   * Time Complexity: O(amount * coins.length)
   * Space Complexity: O(amount * coins.length)
   * 
   * Were you able to solve this on leetcode? Yes
   * Did you have any issues solving this problem? No
   */

  public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length+1][amount+1];
    
    for(int i = 0; i < dp.length; i++){
        dp[i][0] = 1;
    }
    
    for(int i = 1; i < dp.length; i++){
        for(int j = 1; j < dp[0].length; j++){
            if(coins[i-1] > j){
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
    }
    
    return dp[coins.length][amount];
}
}