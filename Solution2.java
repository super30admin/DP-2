// TC: O(m * n) SC: O(m * n)
// Ran on Leetcode: Yes
/* 
Recursively choose and dont choose till we get the amount, and add the choose and no choose case and store it in dp array
*/
class Solution2 {
    public int change(int amount, int[] coins) {
        int rLen = coins.length;
        int cLen = amount;
        int[][] dp = new int[rLen + 1][cLen + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= rLen; i++){
            for(int j = 0; j <= cLen; j++){
                if(j < coins[i - 1]){
                    // no choose case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // sum of choose case and no choose case
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[rLen][cLen];
    }
}