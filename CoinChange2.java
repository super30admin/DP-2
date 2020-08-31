// Time Complexity : O(n*m) where n is the length of coins and m is the amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes, base case of returning 1 if amount is 0 no matter what the coins input is, all test cases passed except this
//corrected the base case and it ran for all test cases


class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<=amount;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else if(coins[i-1]==j){
                    dp[i][j]=1+dp[i-1][j];
                }
                else {
                dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
                }
            }
        
        return dp[coins.length][amount];
    }
}