// Time Complexity : O(M*N) where M is the number of rows and N is no.of colors and here N = 3
// Space Complexity : O(M*N) where M is the number of rows and N is no.of colors and here N = 3
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://www.lintcode.com/problem/515/description

class Solution {
public:
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    int minCost(vector<vector<int>> &costs) {
        if(costs.size() == 0)
            return 0;

        // write your code here
        int min_val = INT_MAX;

        vector<vector<int> > dp(costs.size());

        for(int i = 0; i < dp.size(); i++)
            dp[i] = vector<int>(3, -1);

        for(int i = 0; i < 3; i++)
            min_val = min(min_val, helper(costs, 0, i, dp));
        
        return min_val;
    }

    int helper(vector<vector<int>> &costs, int row, int col, vector<vector<int> >& dp){
        if(row == costs.size() - 1)
            return costs[row][col];
        
        if(dp[row][col] != -1)
            return dp[row][col];

        if(col == 0){
            dp[row][col] = min(costs[row][col] + helper(costs, row+1, 1, dp), 
                          costs[row][col] + helper(costs, row+1, 2, dp));
        }
        else if(col == 1){
            dp[row][col] = min(costs[row][col] + helper(costs, row+1, 0, dp), 
                          costs[row][col] + helper(costs, row+1, 2, dp));
        }
        else{
            dp[row][col] = min(costs[row][col] + helper(costs, row+1, 0, dp), 
                          costs[row][col] + helper(costs, row+1, 1, dp));
        }

        return dp[row][col];
    }


};