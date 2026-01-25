// Time complexity : O(N*amount);
// Space Complexity: O(n*amount);


public class Solution {
    int count = 0;
    public int Change(int amount, int[] coins) {

        if(coins == null) return 0;
        int[,] dp = new int[coins.Length + 1 , amount+1];
        dp[0,0] = 1;
        for(int j = 1 ;j<=amount;j++){
            dp[0,j] = 0;
        }

        for(int i=1;i<=coins.Length;i++){
            for(int j=0;j<=amount;j++){
                if(coins[i-1] > j){
                    dp[i,j] = dp[i-1,j];
                }else {
                dp[i,j] = dp[i-1,j] + dp[i,j-coins[i-1]];
                }
            }
        }
    return dp[coins.Length,amount];
    }
}