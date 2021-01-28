// Time Complexity : O(MN) | M is amount, N is coin length
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[amount+1][coins.length+1];

        dp[0][0] = 1; // 1 way to make an amount of 0 with value 0

        for(int i=0;i<=amount;i++){
            for(int j=1;j<=coins.length;j++){
                int coin = coins[j-1];
                if(i-coin>=0){
                    dp[i][j] = dp[i][j-1] + dp[i-coin][j]; //add don't choose coin + choose coin
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[amount][coins.length];
    }
}