// Time Complexity :O(m*n) m=amount , n=no. of coins
// Space Complexity :O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;//the no of ways you can make 0 amount is 1 - so fill the array with 1
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=coins[i-1]){//if amount is greater than the value of coin
                    dp[i][j]+=dp[i][j-coins[i-1]]; //we use the coin 
                }
            }
        }return dp[coins.length][amount];
    }
}