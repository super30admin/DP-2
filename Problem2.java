// LEetcode 518 - Coinchange2

// Time -> O(n*m)
// Space -> O(n*m)
class Solution {
    public int change(int amount, int[] coins) {
        
        int [][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0;i<=amount;i++){
            dp[0][i] = 0;
        }
        
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        
        for(int row=1;row<dp.length;row++){
            for(int col=1; col<=amount; col++ ){
                
                if(col<coins[row-1]){
                    dp[row][col] = dp[row-1][col];
                }else{
                    
                    dp[row][col] = dp[row-1][col] + dp[row][col-coins[row-1]];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}