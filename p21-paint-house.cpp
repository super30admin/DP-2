// Time complexity is O(n)
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int case1 = 0;
        int case2 = 0;
        int case3 = 0;

        for(int i = 0; i < costs.size(); i++) {
            int temp1 = case1;
            int temp2 = case2;
            case1 = costs[i][0] + min(case2, case3);
            case2 = costs[i][1] + min(temp1, case3);
            case3 = costs[i][2] + min(temp1, temp2);

        }

        return min(case1, min(case2, case3));
    }
};

// Time complexity is O(n)
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size() == 0) return 0;
        for(int i = 1; i < costs.size(); i++) {
            costs[i][0] += min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += min(costs[i-1][0], costs[i-1][1]);
        }

        return min(costs[costs.size()-1][0], min(costs[costs.size()-1][1], costs[costs.size()-1][2]));
    }
};
