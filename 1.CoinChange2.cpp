// Time Complexity : o(cost.size)
// Space Complexity : o(cost.size()x3)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
public:
    int helper(int amount, vector<int>& coins, int idx, vector<vector<int>> &dp) {
        if(amount == 0) {
            return dp[amount][idx] = 1;
        }
        if(amount < 0 || idx == coins.size()) {
            return dp[amount][idx] = 0;
        }
        if(dp[amount][idx] != -1) {
            return dp[amount][idx];
        }
        return dp[amount][idx] = helper(amount - coins[idx], coins, idx, dp) + helper(amount, coins, idx + 1, dp);
    }
    int change(int amount, vector<int>& coins) {
        if(amount == 0) return 1;
        vector<vector<int>> dp(amount + 1, vector<int> coins[0].size());
        return helper(amount , coins , 0, dp);
    }
};