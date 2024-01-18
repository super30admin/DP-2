// Time Complexity : O(n*m) where n will be number of coins and m will be the amount
// Space Complexity :O(m)m will be the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
#include <vector>
using namespace std;
class Solution {
public:
       int change(int amount, vector<int>& coins) {
        vector<int> dp (amount+1,0);
        dp[0] = 1;
        for(int j=0;j<coins.size();j++)
        {
            for(int i = 1;i<dp.size();i++)
            {
            
                if(i>=coins[j])
                {
                    dp[i]+=dp[i-coins[j]];
                }
            }
        }
        return dp[amount];
    }
};