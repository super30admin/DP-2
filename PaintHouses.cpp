// Time Complexity : O(n*k) where n will be number of houses and k will be number of colors
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int costRed = costs[0][0];
        int costBlue = costs[0][1];
        int costGreen = costs[0][2];
        for(int i = 1; i < costs.size(); i++) {
            int tempCostRed = costRed;
            int tempCostBlue = costBlue;
            costRed = costs[i][0] + min(costBlue, costGreen);
            costBlue = costs[i][1] + min(tempCostRed, costGreen);
            costGreen = costs[i][2] + min(tempCostRed, tempCostBlue);
        }
        return min({costRed,costBlue,costGreen});
    }
};