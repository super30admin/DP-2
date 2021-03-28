/*
Runtime complexity - O(MN) - where N-number of coins, M - amount
Space Complexity - O(MN) - where N - number of coins, M- amount

This code ran successfully in leetcode
I have also added the brute force method in the bottom although it gave me time limit exceeded when i submitted.
*/


class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null || amount<0)
            return 0;
       int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(coins[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}

/* - Brute force method - time limit exceeded
    return helper(coins,amount,0);
    public int helper(int[] coins,int amount,int index)
    {
        if(amount==0)
            return 1;
        if(amount<0 || index==coins.length)
            return 0;
        int case1=helper(coins,amount-coins[index],index);
        int case2=helper(coins,amount,index+1);
        return case1+case2;
    }
*/
