// Time Complexity :O(m*n) 
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Using Bottom-up Dp.

class Solution {
    public int change(int amount, int[] coins) {
        int c = coins.length;
        int[][] dp = new int[c+1][amount+1];
        dp[0][0] = 1;// There is only one way to make amount 0 which is pick no coins
        for(int i=1; i<=c; i++){
            for(int j=0; j<=amount; j++){
                //calculating number of ways to make amount j using first i coins
                if(j < coins[i-1]){
                    //if amount is greater than coin value, copy value from above
                    dp[i][j] = dp[i-1][j];
                }else{
                    //add the case where we include the coin
                    dp[i][j] = dp[i-1][j] +  dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[c][amount];
    }
}