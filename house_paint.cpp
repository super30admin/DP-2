// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size()==0){
            return 0;
        }
        int n=costs.size();
        for(int i=1;i<n;i++){
            costs[i][0]=costs[i][0]+min(costs[i-1][1], costs[i-1][2]);
            costs[i][1]=costs[i][1]+min(costs[i-1][0], costs[i-1][2]);
            costs[i][2]=costs[i][2]+min(costs[i-1][0], costs[i-1][1]);
        }
        return min(costs[n-1][0], min(costs[n-1][1],costs[n-1][2]));
    }
};
