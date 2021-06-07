// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this -

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        
        int min_val;
        
        for(int i = costs.size()-2; i >= 0; i--)
        {
            for(int j = 0; j < 3; j++)
            {
                min_val = INT_MAX;
                
                //Find the minimum value to paint for that row
                for(int k = 0; k < 3; k++)
                {
                    if(j == k)
                        continue;
                    
                    if(costs[i+1][k] < min_val)
                    {
                        min_val = costs[i+1][k];
                    }
                }
                costs[i][j] += min_val;
            }
        }
        return min(costs[0][0], min(costs[0][1], costs[0][2]));
        
    }
};