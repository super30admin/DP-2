// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.empty() || costs.size() == 0){
            return 0;
        }
        for(int i=costs.size()-2; i>=0; i--){
            costs[i][0] += min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += min(costs[i+1][1], costs[i+1][0]);
        }
        return min(costs[0][0], min(costs[0][1], costs[0][2]));
    }
};
