
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Yes, 


// Your code here along with comments explaining your approach

/*approach
using the same situation of coin change, here instead of taking the minimum of the previous coins, we can add up as we cumulate the choices of the choosing the coin and the amount associated with it.

*/


class Solution {
    public int change(int amount, int[] coins) {
   
       int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i=1;i<=amount;i++)
        {
            dp[0][i]=0;
        }
        
        for(int i=1;i<=coins.length;i++)
        {
            dp[i][0]=1;
        }
        
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}