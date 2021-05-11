//Time complexity - O(n)
// Space complexity - O(n2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int change(int amount, int[] coins) {
        
          
         if(coins.length == 0 || coins == null){return 0;}
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        
        //filling 1st column 0
        for(int i = 0; i < dp.length; i ++){
            
            
            dp[i][0] = 1;
        }
        //filling first row 0
        
        
        for(int i = 1; i < dp.length; i ++){
            
            for(int j = 1; j < dp[0].length; j ++){
                
                //case 0 when the coint denomination is less than the amount
                if(j < coins[i-1]){
                dp[i][j] = dp[i-1][j];
                    
                } 
                
                else{
                    
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]] ;
                }
                
                
                
            }
        }
        
        int result = dp[dp.length-1][dp[0].length - 1];
       
        return result;
        
        
    }
}