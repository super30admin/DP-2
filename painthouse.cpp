// Time Complexity :O(costs.size())
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// In this I will start from second last row and will add current element with min of other two paint 
// costs in the below row ,It will done till the top row ,and then the minimum in top row will be the answer

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        
        for(int i=costs.size()-2;i>=0;i--)
        {
            for(int j=0;j<3;j++)
            {
                if(j==0)
                costs[i][j]=costs[i][j]+min(costs[i+1][j+1],costs[i+1][j+2]);
                else if(j==1)
                costs[i][j]=costs[i][j]+min(costs[i+1][j-1],costs[i+1][j+1]);
                else
                costs[i][j]=costs[i][j]+min(costs[i+1][j-1],costs[i+1][j-2]);

            }
        }
        int ans=INT_MAX;
        for(int i=0;i<costs[0].size();i++)
        ans=min(ans,costs[0][i]);

        return ans;

    }
};