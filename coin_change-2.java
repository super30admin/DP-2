// Time complexity : O(m *n)
// space complexity : O(m *n) 
// m = no of different coins (denominations)
// n = amount value

class Solution {
    public int change(int amount, int[] coins) {
        // 2 D array : Rows -> coins , column -> (0-amount)
        int[][] dp =  new int[coins.length + 1][amount + 1];
        
        // First row
        for (int i = 1; i <= amount ; i++){
            dp[0][i] = 0; // no min coins needed
        }
        
        // First column
        for (int i = 0; i <= coins.length ; i++){
            dp[i][0] = 1;
        }
        
        // Update other cells
        for (int i = 1; i <= coins.length; i++){
            
            for (int j = 1; j <= amount; j++){
                
                // new coin is less than the coin value
                if (j < coins[i-1]){
                    
                    // update the previous row value as its value
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    // total combinations  : Coin considered case + not considered case
                    dp[i][j] = dp[i-1][j]  +  dp[i][j - coins[i-1]];
                }
            }
        }
        
        return dp[coins.length][amount];
        
    }
}