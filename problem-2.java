// Time Complexity : O(n*amount)
// Space Complexity : O(n*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int count=0;
        int[][] dp = new int[coins.length+1][amount+1];
        //Initialize first element with '1' since the total number of ways with which we can form a amount 0 with 0 is '1'(by choosing/not choosing)
        dp[0][0]=1;
        //Initialize dummy row with '0' since the total number of ways with which we can form a amount greater than 0 with 0 is '0'
        for(int j=1; j<dp[0].length; j++){
            dp[0][j]=0;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                //if the denomination > amount, then the total number of ways with which we can form that amount is by not choosing that denomination (i.e dp[i-1][j]);
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                //if the denomination <= amount, then the total number of ways with which we can form that amount is the sum of the total num of ways by not choosing that denomination (i.e dp[i-1][j]) and the total number of ways to form amount-denomination (i.e by choosing that denomination) dp[i][j-coins[i-1]].
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        //Finally return the total number of ways to form the max amount with maximum denominations
        return dp[coins.length][amount];
        
        //Optimization
        //Since each element in dp matrix atmost uses the row just above it, we can simply maintain a 1D array (by overwriting) thereby reducing the SC to O(amount)
    }
}
