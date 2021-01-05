/**
 * Time complexity - O(n*amount) where n is length of input array coins
 * Space complexity - O(n*amount)
 * All test cases passed
 */
class Solution {
    public int change(int amount, int[] coins) {
        //There are two cases
        //either I choose that coin or don't choose that coin
        //If the amount is equal to 0 we cna return that it is a valid path
        //Make two cases
        //Choose a coin and don't choose a coin

        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<dp.length; i++)
        {
            dp[i][0]=1;
        }

        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}