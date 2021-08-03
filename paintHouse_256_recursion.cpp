class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.empty() || costs.size() == 0){
            return 0;
        }
        int case1 = helper(costs, 0, 0, 0);
        int case2 = helper(costs, 0, 1, 0);
        int case3 = helper(costs, 0, 2, 0);
        int x = min(case2, case3);
        return min(case1, x);
    }
    int helper(vector<vector<int>>& costs, int row, int color, int minCost){
        if(row == costs.size())
            return minCost;
        
        if(color == 0){
            return min(helper(costs, row+1, 1, minCost+costs[row][0]),
                      helper(costs, row+1, 2, minCost+costs[row][0]));
        }
        if(color == 1){
            return min(helper(costs, row+1, 0, minCost+costs[row][1]),
                      helper(costs, row+1, 2, minCost+costs[row][1]));
        }
        return min(helper(costs, row+1, 0, minCost+costs[row][2]),
                      helper(costs, row+1, 1, minCost+costs[row][2]));
    }
};
