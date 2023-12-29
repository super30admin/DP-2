// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea is to create variables to store cost in each path. We return
// the minimum of those 3 path at the end. 

#include <vector>
class Solution {
public:
    int minCost(std::vector<std::vector<int>>& costs) {
        int h = costs.size();

        int costR = costs[h-1][0];
        int costB = costs[h-1][1];
        int costG = costs[h-1][2];

        for(int i = h-2; i>=0; i--)
        {
            int tempR = costR;
            costR = costs[i][0] + std::min(costB,  costG);
            int tempB = costB;
            costB = costs[i][1] + std::min(tempR,  costG);
            int tempG = costG;
            costG = costs[i][2] + std::min(tempR,  tempB);
        }

        return std::min(costR, std::min(costB, costG));
    }
};