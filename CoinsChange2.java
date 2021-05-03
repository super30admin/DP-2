// Time Complexity : O(NK) where N is length of coins and K is amount+1
// Space Complexity :O(NK) where N is length of coins and K is amount+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class CoinsChange2 {
    public int change(int amount, int[] coins) {
        int max = amount + 1;
    int[][] dp = new int[coins.length+1][amount + 1];
   
      for(int i=0;i<dp.length;i++){
          dp[i][0]=1;   
      }
      
   
    for (int i = 1; i <dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if ( coins[i-1] > j) {  // check if coins is less than amount
         
            dp[i][j]=dp[i-1][j]; // since its less coin will not be considered
        }
          else{ // coin may or may not be considered. Add up both cases to get number of combinations
              dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
              
          }
      }
    }
      
    return dp[dp.length-1][dp[0].length-1]; // last element at matrix will have number of combinations
  }   
    }
