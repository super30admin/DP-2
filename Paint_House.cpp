class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        vector< vector<int>> dp(n, vector<int>(3,0));
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];
        for(int i=n-2;i>=0;i--){
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1]);
        }
    return min(dp[0][0], min(dp[0][1], dp[0][2]));
    }
};


// we can further optimise it by using a single array of 3 elements and we can then further optimise it by taking three variables only(as 3 colours)- This optimisation that we are talking about is for space and time complexity is already  optimised.
