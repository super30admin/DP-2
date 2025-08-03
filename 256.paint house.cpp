/**his code finds the cheapest way to paint all the houses so that no two next to each other have the same color. 
It works by starting from the last house and moving backward
always picking the cheapest valid option***/
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int m = costs.size();
        int n = costs[0].size();

        vector<vector<int>> dp(m, vector<int>(n));

        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i = m - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1]);
        }

        return min(dp[0][0], min(dp[0][1], dp[0][2]));
    }
};