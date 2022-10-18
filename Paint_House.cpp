/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

    int minCost(vector<vector<int>>& costs) {
        vector<int> prev(costs.size(),0);
        int ans=0;
        prev[0] = costs[0][0];
        prev[1] = costs[0][1];
        prev[2] = costs[0][2];
    
        for(int i = 1; i<costs.size();i++){
            int cr = prev[0], cg = prev[1], cb = prev[2];
            prev[0] = costs[i][0] + min(cg,cb);
            prev[1] = costs[i][1] + min(cr,cb);
            prev[2] = costs[i][2] + min(cr,cg);
            
            
        }
        ans = min(prev[0],min(prev[1],prev[2]));
        return ans;
    }
    
int main(){
    std::vector<vector<int>> costs = {{20,20,30},{30,17,30}};
    int aa= minCost(costs);
    cout<<aa;
    return aa;
}