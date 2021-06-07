// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int change(int amount, int[] coins) {
        //null case
        if(coins.length == 0 || amount == 0)
            return 0;
        int dp[][] = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        //first column
        for(int i = 1;i < dp.length;i++)
            dp[i][0] = 1;
        //first row
        for(int j = 1;j < dp[0].length;j++)
            dp[0][j] = 0;
        for(int i = 1;i < dp.length;i++)
            for(int j = 1;j < dp[0].length;j++){
                //when amount is less than the coin
                if(j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                //total ways to make amount j considering coins till i
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}