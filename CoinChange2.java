//Problem - CoinChange 2
// Time Complexity : O(c*a), where c represents coins length and a represents amount
// Space Complexity : O(c*a), where c represents coins length and a represents amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**  Steps 
 *  Initialise Dp col 1 with 1 because, if amount is 0, then there is only 1 way to make that amount. For dp[0][0], assume that you have empty subset which means 0 and u have to make an amount 0, it means 1 option is there that is null/empty subset.  
 * 
 * 
*/


class Solution23 {
    
    public int change(int amount, int[] coins) {
      
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=coins[i-1]){
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[coins.length][amount];
        
    }
    
}
/*
TC & SC same as above
class Solution23TopDown {
    
    private Integer[][] dp;
    
    public int change(int amount, int[] coins) {
      
        if(amount > 0 && coins.length==0){
            return 0;
        }
        
        if(coins==null || coins.length==0){
            return 1;
        }
        
        dp = new Integer[coins.length+1][amount+1];
        
        return calcNumComb(coins,amount,coins.length-1);
    }
    
    
    private int calcNumComb(int[] coins, int amount, int n){
        
        //base
        if(n<0 || amount<0){
            return 0;
        }
        
        if(amount==0){
            return 1;
        }
        
        if(dp[n][amount]!=null){
            return dp[n][amount];
        }
        
        //logic
        if(amount>=coins[n]){//
            return dp[n][amount] = calcNumComb(coins,amount-coins[n],n)+calcNumComb(coins,amount,n-1);    
        }else{
            return dp[n][amount] = calcNumComb(coins,amount,n-1);
        }
        
    }
    
}
*/