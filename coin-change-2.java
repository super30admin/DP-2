
//Time complexity: O(m*n), where m and n are rows and cols of the dp array
//Space complexity: O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
        if (coins==null || coins.length==0)
        {
            return 0;
        }
        //return helper(coins, amount, 0);
       //DP matrix approach
        //rows= length of coins and +1 for the oth coin
        //columns= amount and +1 to include the last column value because index starts from 0
        int[][] dp= new int[coins.length+1][amount+1];
        for(int i=0; i<dp.length; i++)
        {
            //fill 0th column for each row with 0
            //0the column is amount 0 and it can be made only 1 way by any coin
            dp[i][0]=1;
        }
        //i and j start from 1 coz col0 is already filled and row 0 will be 0
        //empty space in the dp will be by default 0 for java
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                //if (coins[i-1]>=j), why is this not working
                if (j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
    return dp[dp.length-1][dp[0].length-1];
}
}
