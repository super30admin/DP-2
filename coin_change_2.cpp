// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea is to create an array to store one coin combinations. Replace
// those array values with next coin combinations. Last element of the
// array after all coin combinations gives us total combinations. 

#include <vector>

class Solution {
public:
    int change(int amount, std::vector<int>& coins) {
        int m = coins.size();
        int n = amount;
        
        // Vector to store one coin combinations.
        std::vector<int> dp(n+1, 0);

        //set initial combination as 1 for 0 coins and 0 amount.
        dp[0] = 1;

        for(int i = 1; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(j < coins[i-1])
                {
                    dp[j] = dp[j];
                }
                else
                {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
};