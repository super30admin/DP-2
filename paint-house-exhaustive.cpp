// Time Complexity : O(3^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No (Time Limit exceeded)

#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int case1 = helper(costs, 0, 0, 0);
        int case2 = helper(costs, 0, 0, 1);
        int case3 = helper(costs, 0, 0, 2);
        return min(case1, min(case2, case3));
    }

private:
    int helper(vector<vector<int>>& costs, int minCost, int row, int lastColor) {
        if (row == costs.size())
            return minCost;

        int case1 = INT_MAX;
        int case2 = INT_MAX;
        int case3 = INT_MAX;

        if (lastColor == 0) {
            case1 = min(helper(costs, minCost + costs[row][1], row + 1, 1),
                        helper(costs, minCost + costs[row][2], row + 1, 2));
        }
        else if (lastColor == 1) {
            case2 = min(helper(costs, minCost + costs[row][0], row + 1, 0),
                        helper(costs, minCost + costs[row][2], row + 1, 2));
        }
        else if (lastColor == 2) {
            case3 = min(helper(costs, minCost + costs[row][0], row + 1, 0),
                        helper(costs, minCost + costs[row][1], row + 1, 1));
        }

        return min(case1, min(case2, case3));
    }
};

