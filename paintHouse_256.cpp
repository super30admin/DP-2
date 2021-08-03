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
        int red = costs[costs.size()-1][0],
            green = costs[costs.size()-1][1],
            blue = costs[costs.size()-1][2];

        for(int i=costs.size()-2; i>=0; i--){
            int temp1 = costs[i][0];
            int temp2 = costs[i][1];
            int temp3 = costs[i][2];
            
            int ex1 = red;
            int ex2 = green;
          
            red = temp1 + min(ex2, blue);
            green = temp2 + min(ex1, blue);
            blue = temp3 + min(ex1, ex2);
        }
        return min(red, min(green, blue));
    }
};
