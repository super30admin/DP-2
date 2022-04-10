// Time Complexity                              :  O(N)
// Space Complexity                             :  O(1)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        if(n == 0) return 0;
        int colors = costs[0].size();
        
        for(int i = n-2;i>=0;i--) {
            //if red was selected, we can select blue and green for the next step.
            costs[i][0] += min(costs[i+1][1], costs[i+1][2]);
            // if blue was selected, we can select red and green for the next step.
            costs[i][1] += min(costs[i+1][0], costs[i+1][2]);
            // if green was selected, we can select red and blue for the next step.
            costs[i][2] += min(costs[i+1][0], costs[i+1][1]);
        }
        
        return min(costs[0][0],min(costs[0][1],costs[0][2]));
    }
};