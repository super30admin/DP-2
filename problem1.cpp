// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// we did use bottom up approach in dp by modifying the existing costs matrix.
// everytime we should select a min of two of the adjacent possibilities.



class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.empty() || costs.size()==0){
            return -1;
        }
        for(int i= costs.size()-2;i>=0;i--)
        {
            for(int j=0;j<3;j++)
            {
                if(j==0)
                    costs[i][j] = costs[i][j] + min(costs[i+1][1], costs[i+1][2]);
                else if(j==1)
                    costs[i][j] = costs[i][j] + min(costs[i+1][0], costs[i+1][2]);
                else
                    costs[i][j] = costs[i][j] + min(costs[i+1][0], costs[i+1][1]);
            }
        }
        return min(costs[0][0], min(costs[0][1],costs[0][2]));
    }
};
