//Time Complexity-O(m*n)
//Space Complexity-O(m*n)
//Runs successfuly on leetcode


class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        
        int n = costs.size(); 
        if (!n) return 0;
        
        vector<vector<int>>dp(n, vector<int>(3, 0));
        for (int j = 0; j < 3; j++)
            dp[0][j] = costs[0][j];
        
        for (int i = 1; i < n; i++) {
            dp[i][0] =  min(dp[i-1][1], dp[i-1][2])+costs[i][0];
            dp[i][1] =  min(dp[i-1][0], dp[i-1][2])+costs[i][1];
            dp[i][2] =  min(dp[i-1][0], dp[i-1][1])+costs[i][2];
        }
        
        return min(dp[n-1][0], min(dp[n-1][1], dp[n-1][2]));
    }
};