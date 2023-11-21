//Time Complexity:O(mxn) => O(3xn) => O(n)
// Space Complexity: O(n)

class Solution {
public:
    int minCost( vector<vector<int>>& costs) {

        if(costs.size() == 0) return 0;

        int m = costs.size() - 1;

        int dp[m][3];

        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i = m-2; i>= 0; i--)
        {
            dp[i][0] = costs[i][0] + min (dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + min (dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + min (dp[i+1][0], dp[i+1][1]);

        }

        return min(dp[0][0], min(dp[0][], dp[0][2]));
    }