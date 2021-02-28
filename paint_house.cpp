// Time Complexity: O(N)Where N is the size of costs array(No. of rows)
// Space Complexity: O(3N) or O(N) where is the amaount
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int rows = costs.size();
        int cols = 3;//0->R//1->B//2->G
        if(costs.size()==0)return 0;
        int t[rows][cols];
        for(int i = 0; i < cols;i++){
            t[0][i] = costs[0][i];
        }
        for(int i = 1; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(j==0) t[i][j] = costs[i][j] + min(t[i-1][1],t[i-1][2]);
                else if(j==1)t[i][j] = costs[i][j] + min(t[i-1][0],t[i-1][2]);
                else t[i][j] = costs[i][j] + min(t[i-1][0],t[i-1][1]);
            }
        }
        int mn = min(t[rows-1][0],t[rows-1][1]);
        return min(mn,t[rows-1][2]);
        
    }   
};