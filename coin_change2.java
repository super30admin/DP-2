// Time Complexity :O(n m) n-length of the array coins. m- array created with length amount+1
// Space Complexity :O(n m) 
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this : -
class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1; // If amount is 0 return 1
        if(coins==null || coins.length==0) return 0; // If there are no coins return 0
        int[][] dp=new int[coins.length+1][amount+1]; // determining the size of the array
        int n=dp.length;
        int m=dp[0].length;
     
        for(int i=1;i<n;i++)
        {
            dp[i][0]=1; // allocating default value
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(coins[i-1]>j) //if coin is greater the amount then just copy previous row's combination
                {
                     dp[i][j]=dp[i-1][j];
                }else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]; // if coin is lesser than amount then add previous row's combination and find current coin's combination by j-coins[i-1]
                }
            }
        }
 
        return dp[n-1][m-1];
        
    }
}