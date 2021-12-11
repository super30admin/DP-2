// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We take 0 row at begining.
 * For each row we calculate number of ways to form all amounts till the target one.
 * Total no of ways = no of ways to form current amount without current coin  + with current coin
 * Total no of ways to form amount with current coin = no of ways to form (amount - coins[r-1]) with current coin + no of ways to form current amount without current coin
 * If current amount < coin value, then we simply take no of ways to form this amount without current coin.
 * At last row last column, we ge total no of ways to form target amount with given coins.
*/

class Solution {
    
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        dp[0][0] = 1;
        for(int c = 1; c < dp[0].length;c++)dp[0][c] = 0;
    
        for(int r = 1; r < dp.length;r++){
          for(int c = 0; c < dp[0].length;c++){
              
              if(c < coins[r-1]){
                  dp[r][c] = dp[r-1][c];
              }else{
              dp[r][c] = dp[r-1][c] + dp[r][c - coins[r-1]];    
              }
          }  
        }
        
        return dp[coins.length][amount];
        
        return cal(coins, 0, amount, 0, 0);
    }
    
    public int cal(int[] coins, int index, int amount, int total, int ans){
        //base case
        if(total > amount || index == coins.length)return 0;
        if(total == amount)return ans + 1;
        
        
        //logic
        
        int case1 = cal(coins, index, amount, total + coins[index], ans);
        int case2 = cal(coins, index+1, amount, total, ans);
        
        return case1 + case2;
    }
    
   
}