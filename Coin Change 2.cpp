// Time Complexity : O(M*N) where M is the number of coins and N is amount
// Space Complexity : O(M*N) where M is the number of coins and N is amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/coin-change-2/
// Submission Link: https://leetcode.com/submissions/detail/533169381/

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int> > dp(coins.size() + 1);
        
        for(int i = 0; i <= coins.size(); i++){
            dp[i] = vector<int>(amount + 1, 0);
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < dp.size(); i++){
            for(int j = 1; j < dp[0].size(); j++){
                if(j < coins[i - 1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        
        return dp[coins.size()][amount];
    }
};