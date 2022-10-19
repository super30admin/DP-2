// Approach : bottom up dynamic programming
// Time Complexity: O(N * amount), where N is the number of coin denominations available
// Space Complexity: O(N * amount)
public class Solution {
    public int Change(int amount, int[] coins) {
        int[,] dp = new int[coins.Length+1, amount+1];
        
        for(int i=0; i<=coins.Length; i++){
            for(int j=0; j<=amount; j++){
                if(i==0 || j == 0){
                    // first row corresponds to empty coins array. with no denominations there are zero ways to make an amount
                     if(i==0)
                        dp[i,j] = 0;
                    // first column corresponds to amount zero. We can make amount zero by not picking any coin in 1 way
                    if(j==0)
                        dp[i, j] = 1;
                } else{
                    var select = j < coins[i-1] ? 0 : dp[i, j-coins[i-1]];
                    var notselect = dp[i-1, j];
                    dp[i, j] = select + notselect;
                }
            }
        }
        
        return dp[coins.Length, amount];
    }
}
