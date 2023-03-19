class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
    int row = costs.size();
    // int coloumn =  costs[0].size();
    
        for(int i = row-2;i>=0;i--){
            // for(int j= 0; j<3; j++){
                // if(j=)
              costs[i][0] = costs[i][0]+ min(costs[i+1][1], costs[i+1][2]);
              costs[i][1] = costs[i][1]+ min(costs[i+1][0], costs[i+1][2]);
              costs[i][2] = costs[i][2]+ min(costs[i+1][1], costs[i+1][0]);
            // }
        }
        return min(costs[0][0], min(costs[0][1],costs[0][2]));
        
        
    }

};