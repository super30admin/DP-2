// Time Complexity :O(n) 
// Space Complexity : O(1) Optimized  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int chooseRed,chooseBlue,chooseGreen;
        chooseRed = costs[costs.size()-1][0];
        chooseBlue = costs[costs.size()-1][1];
        chooseGreen = costs[costs.size()-1][2];
        int tempRed,tempBlue;
        for(int i = costs.size()-2; i>=0;i--){
            tempRed = chooseRed;
            tempBlue = chooseBlue;
            chooseRed = costs[i][0] + min(chooseBlue,chooseGreen);
            chooseBlue = costs[i][1] + min(tempRed,chooseGreen);
            chooseGreen = costs[i][2] + min(tempRed,tempBlue);
        }
        return min(chooseRed, min(chooseBlue,chooseGreen));
    }
};