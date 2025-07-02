// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// approach:Use a 2D DP array where rows represent coins and columns represent amounts.
// For each cell, if the current coin value is greater than the amount, copy from the previous row (not pick).
// Else, add ways from previous row (not pick) and current row at (amount - coin value) (pick).
// The final cell gives total combinations to make the target amount using all coins.
class Solution {
    public int change(int amount, int[] coins) {
    if(coins==null || coins.length==0){
        return 0;
    }
    int dp[][] = new int [coins.length+1] [amount+1];
    for(int i=0;i<coins.length+1;i++){
        dp[i][0]=1;
    }
    for(int i=1;i<coins.length+1;i++){
        for(int j=1;j<amount+1;j++){
            if(j<coins[i-1]){
                dp[i][j]= dp[i-1][j];;
            } else{
                dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
    }
    return dp[coins.length][amount];
    }
}