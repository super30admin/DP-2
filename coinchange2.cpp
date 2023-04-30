// Time Complexity : O(amount*coins)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// In this the deciding factors are amount and the coins array , So I decided to take a 2D array in 
// which coins array elements as the column and amount as the rows. Extra row and column has been taken
// to avoid the boundary checkings while we try to fill the remaining columns;
// The matrix contains the number of combinations of particular amount



class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        vector<vector<int>>dp(coins.size()+1,vector<int>(amount+1,0));

        for(int i=0;i<dp.size();i++)
        dp[i][0]=1;

        for(int i=1;i<dp.size();i++)
        {
            for(int j=1;j<dp[0].size();j++)
            {
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else 
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }

        return dp[coins.size()][amount];
        

    }
};