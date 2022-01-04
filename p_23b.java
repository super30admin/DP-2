// Time Complexity :o(m*n)
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution {
    public int change(int amount, int[] coins) {
      int [][] dp = new int [coin.length + 1] [amount + 1];
      for(int i = 0 ; dp.length ; i++){
          dp[i][0] = 1;
      }
      for(int i = 1 ; i < dp.length ; i++){
          for(int j = 1 ; j < dp[0].length ; j++){
              //case 1 : available till amt < denomination
              if(j < coins[i -1]){
                  dp[i][j] = dp[i - 1][j];
              }else{
                  dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
              }
          }
      }
      return  dp[dp.length - 1][dp[0].length - 1];
    }
}