// Time Complexity :O(N*M) where n is the amount and M is the number of coins
// Space Complexity :O(N*M) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Calculating the number of ways for each amount using the given set of coins 
// can be calculated by the total of number of ways reaching the amount without the present coin and number of ways reaching the (amount-
// present coin value).

class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null)
            return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];}
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }}
        }
        return dp[coins.length][amount];
    }
}