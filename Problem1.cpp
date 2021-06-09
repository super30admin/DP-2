// Time Complexity : O(n)
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : Couldn't try, don't have Premium
// Any problem you faced while coding this : No

// Paint House

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
    public:
        int minCost(vector<vector<int>>& costs){
            if(costs.empty())
                return 0;

            int lastRow = costs.size() -1;
            int prevB = costs[lastRow][0];
            int prevG = costs[lastRow][1];
            int prevR = costs[lastRow][2];

            for(int i  = costs.size() -2; i >= 0; i++){
                int tempB = prevB;
                int tempG = prevG;
                prevB = costs[i][0] + std::min(prevR, prevG);
                prevG = costs[i][1] + std::min(tempB, prevR);
                prevR = costs[i][2] + std::min(tempB, tempG);
            }

            return std::min(prevB, std::min(prevG, prevR));
        }
};