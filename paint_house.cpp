//TC: O(n) where n is the number of houses
//SC: O(1)

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        
        //find minimum paint cost for adjacent houses at every level in every color. Store this value in place of the earlier value. Continue till the last.
        //assumption in the problem is that if we store minimum combination at every level, we will eventually reach the minimum value at the last level.
        
        if(costs.empty()) return 0;
        
        for(int i=1; i<costs.size(); i++){
            
            costs[i][0] +=  min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += min(costs[i-1][0], costs[i-1][1]);
                        
        }
        
         return min(costs[costs.size()-1][0], min(costs[costs.size()-1][1], costs[costs.size()-1][2]));
        
    }
};