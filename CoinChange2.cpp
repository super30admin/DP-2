// Time Complexity : O(N*M) where N=Number of coins and N->Amount
// Space Complexity : O(NK)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int change(int amount, vector<int>& coins) {

        if(coins.size()==0 && amount ==0) return 1;
        if(coins.size() ==0) return 0;
        vector<vector<int>> dp(coins.size()+1,vector<int>(amount+1,0));

        int m= coins.size()+1,n=amount+1;

          for(int i=0;i<n;i++)
          {
            dp[0][i] = 1;
          }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-dp[i][j-coins[i-1]]];
                }
            }
        }
        return dp[coins.size()][amount];
