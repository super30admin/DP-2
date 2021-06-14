//Time Complexity=O(n)
//Space Complexity=O(1) no extra space is used so the space complexity 

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        for (int i = costs.size() - 2; i >= 0; i--){
            costs[i][0] = costs[i][0] + min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1] + min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] = costs[i][2] + min(costs[i+1][1],costs[i+1][0]);
        }
        return *min_element(costs[0].begin(),costs[0].end());
    }
};