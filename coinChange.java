//Time Complexity: O(mn)
//Space Complexity: O(mn)
//Did run on leetcode.
class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length+1;
        int n= amount+1;
        int [][]dp = new int[m][n];        //Choosen an array to store values of previous sum.
        for(int i=0; i<m;i++)
            dp[i][0] = 1;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)				//	if requied amount is less than coin available value to be carried from previous 
            {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];				// else summation of coin and previously used coin will give the required amount.
                else
                {
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}