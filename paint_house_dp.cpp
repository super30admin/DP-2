//paint house problem using dp matrix

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.empty() || costs.size() == 0) return 0;

        int n = costs.size();
        int dp[n][3];          //[house_no][color]

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        int m = sizeof(dp)/sizeof(dp[0]);

        for(int i = 1; i <m; i++){
            dp[i][0] = std::min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = std::min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = std::min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }

        return std::min(dp[m-1][0], std::min(dp[m-1][1], dp[m-1][2]));
    }
};

//Time Complexity: O(n)
//Space Complexity: O(n) 
