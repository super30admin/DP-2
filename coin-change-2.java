// Time : O(amount*coins.length)
// Space: O(amount*coins.length)

class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0 || coins == null){
          return 0;
        }
      if(amount ==0){
        return 1;
      }
      
        int[][] dp = new int[coins.length+1][amount+1];
      
      for(int i=0;i<=coins.length;i++){
        for(int j=0;j<=amount;j++){
            dp[0][j] = 0;
            dp[i][0] = 1;
          
          if(i>0){
            if(j < coins[i-1]){
              dp[i][j] = dp[i-1][j];
            }
             else{
              dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
            
          }
            //System.out.print(dp[i][j]);
        }
        //System.out.println();
      }
      
      return dp[coins.length][amount];
    }
}
