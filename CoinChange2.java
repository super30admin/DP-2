// Time Complexity : O(nxm)
// Space Complexity : O(nxm)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int change(int amount, int[] coins) {

        //explaination in March 9 class, we use dp matrix because there are 2 constraints -
        //amount and denominations, also see coin change 1 solution

        int[][] dp = new int[coins.length+1][amount+1];

        //first col will be all 1s because one way of making amount=0, don't choose

        for(int i=0; i<dp.length; i++)
            dp[i][0] = 1;

        //fill the matrix
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                int cd = coins[i-1];
                if(cd > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-cd];
            }
        }
        return dp[coins.length][amount];
    }
}
