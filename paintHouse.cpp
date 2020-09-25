// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size() == 0)
            return 0;
        
        int mincost = INT_MAX;
        
        //DP of costs size vs color options
        vector<vector<int>> dp(costs.size(), vector<int>(3, INT_MAX));
        
        //Check for all the house
        for(int i = 0; i < costs.size(); i++)
        {
            //Check for all three colors
            for(int j = 0; j < 3; j++)
            {
                dp[i][j] = costs[i][j]; //Cost of selecting this color.
                
                //Min Cost of the color on the previous house of not the same color.
                if(i!= 0)
                    dp[i][j] +=  min( dp[i-1][(j+1)%3], dp[i-1][(j+2)%3] );
                
                //Min of the last house contains the answer.
                if(i == costs.size()-1)
                    mincost = min(mincost, dp[i][j]);
            }
        }
        
        return mincost;
    }
};