// Time complexity O(m*n)
// Space complexity O(n)
class Solution {

    int minCost(const vector<int>& costs, int idx = -1) {
        int minimum = INT_MAX;
        for (int j = 0; j < costs.size(); j++) {
            if (j == idx) continue;
            minimum = min(minimum, costs[j]);
        }
        return minimum;
    }
    
public:
    int minCost(vector<vector<int>>& costs) {
        int m = costs.size();
        int n = costs[0].size();

        vector<int> memo(n, 0);
        for (int j = 0; j < n; j++) {
            memo[j] = costs[0][j];
        }

        for (int i = 1; i < m; i++) {
            vector<int> copy = memo;
            for (int j = 0; j < n; j++) {
                memo[j] = costs[i][j] + minCost(copy, j);
            }
        }

        return minCost(memo);
    }
};