// Time Complexity : O(m*n) m = amount, n= no of coins
// Space Complexity : O(m) m= amount
// Did this code successfully run on Leetcode :
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount+1];
        dp[0] =1;
        
        for(int i=1;i<=coins.length;i++){
            for(int j=1; j<=amount; j++){
                if(j<coins[i-1]){
                    dp[j]=dp[j];
                }else{
                    dp[j]= dp[j] + dp[j-coins[i-1]];
                }
            }
        }
            
        return dp[amount];
        
    }
    
}
