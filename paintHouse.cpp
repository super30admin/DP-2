/* ################################################## Recursive Solution ################################################## */

class Solution {
public:
    int helper (vector<vector<int>>& costs, int i, int col)
    {
        if (i == costs.size()) {
            return 0;
        }

        if (col == 0) {
            return costs[i][col] + min(helper(costs, i + 1, 1),helper(costs, i + 1, 2)); 
        }

        if (col == 1) {
            return costs[i][col] + min(helper(costs, i + 1, 0),helper(costs, i + 1, 2));
        }

        if (col == 2) {
            return costs[i][col] + min(helper(costs, i + 1, 1),helper(costs, i + 1, 0));
        }

        return 0;
    }
    int minCost(vector<vector<int>>& costs) 
    {
        return min(helper(costs, 0, 0), min(helper(costs, 0, 1), helper(costs, 0, 2)));
    }
};


/* ################################################## DP Solution ################################################## */

class Solution {
public:
    int minCost(vector<vector<int>>& costs) 
    {
        int dp[3];

        int n = costs.size();
        dp[0] = costs[n - 1][0];
        dp[1] = costs[n - 1][1];
        dp[2] = costs[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            int temp0 = dp[0];
            dp[0] = costs[i][0] + min(dp[1], dp[2]);

            int temp1 = dp[1];
            dp[1] = costs[i][1] + min(temp0, dp[2]);

            dp[2] = costs[i][2] + min(temp1, temp0);
        }

        return min(dp[0], min(dp[1], dp[2]));
    }
};


