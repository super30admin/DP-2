// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode!

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int m = costs.size();
        vector<vector<int>> dp(m, vector<int>(3));
        
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];
        
        for(int i = m-2; i >= 0; i--){
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][0]);
        }
        
        return min(dp[0][0], min(dp[0][1], dp[0][2]));
    }
};
