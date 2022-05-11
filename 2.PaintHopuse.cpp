// Time Complexity : o(coins*amount)
// Space Complexity : o(amount)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        vector<vector<int>> dp(costs.size(), vector<int>(3, 0));
        int n = costs.size();
        int m = costs[0].size();
        
        for(int i=0;i<n;i++) {
            if(i == 0) {
                dp[i][0] = costs[i][0];
                dp[i][1] = costs[i][1];
                dp[i][2] = costs[i][2];
                continue;
            }
            dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        return min({dp[n-1][0], dp[n-1][1], dp[n-1][2]});
    }
};