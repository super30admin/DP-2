//paint house dp problem with the costs array mutated and space complexity O(1)
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.empty() || costs.size() == 0) return 0;

        int n = costs.size();


        for(int i = 1; i <n; i++){
            costs[i][0] = std::min(costs[i-1][1], costs[i-1][2]) + costs[i][0];
            costs[i][1] = std::min(costs[i-1][0], costs[i-1][2]) + costs[i][1];
            costs[i][2] = std::min(costs[i-1][0], costs[i-1][1]) + costs[i][2];
        }

        return std::min(costs[n-1][0], std::min(costs[n-1][1], costs[n-1][2]));
    }
};


//Time Complexity : O(n)
//Space Complexity: O(1)
