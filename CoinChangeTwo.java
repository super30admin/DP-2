// Time Complexity : O(N*M)
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*

It is similar to coin change 1 problem. 
Over here for every dp[i][j] value, we add the entry that is top of it and 
the entry that you find when you do current amount - current coin in that row.

*/

public class CoinChangeTwo {
    
    public static int change(int amount, int[] coins)
    {
        if(coins==null || coins.length== 0 )
        {
            return 0;
        }

        int[][] dp = new int[coins.length+1][amount+1];

        //1st column
        for(int i = 0;i<dp.length;i++)
        {
            dp[i][0]=1;
        }

        for(int i = 1;i<dp.length;i++)
        {
            for(int j = 1;j<dp[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];
    }


    public static void main(String args[])
    {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(change(amount, coins));
    }

}
