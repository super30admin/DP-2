//T : O(3*N)
//S : O(1)

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {


        if(costs.size() == 0  || costs[0].size()==0) return 0;
        //if(costs.size() == 1) return min(costs[0][0], min(costs[0][1], costs[0][2]));
        int i;
        int sz = costs.size()-1;
        for( i = 1; i < costs.size(); i++){
            costs[i][0] += min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += min(costs[i-1][0], costs[i-1][1]);
        }

        return min(costs[sz][0], min(costs[sz][1], costs[sz][2]));


    }
};
