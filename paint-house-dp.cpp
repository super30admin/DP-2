// Time Complexity : O(amount * coins.length)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    static int minCost(vector<vector<int>>& costs) {
        if (costs.empty() || costs[0].empty())
            return 0;

        for (int i = 1; i < costs.size(); i++) {
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1]);
        }

        int m = costs.size() - 1;
        return min(min(costs[m][0], costs[m][1]), costs[m][2]);
    }
};