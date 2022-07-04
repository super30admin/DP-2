// Problem1(https://leetcode.com/problems/paint-house/)
// Time Complexity : O(m) where m is the size of the matrix  
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution{
    public int minCost(vector<vector<int>> costs){
        if(costs.size() == 0){
            return 0;
        }
        
        //columns are going to be constant 3
        int m = costs.size();
        vector<vector<int>> dp(m, vector<int>(3,0));
        for(int i = m-2;i>=0;i--){
            dp[i][0] = dp[i][0] + min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = dp[i][1] + min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = dp[i][2] + min(dp[i+1][1], dp[i+1][0]);
        }
        return min(dp[i][0], min(dp[i][1], dp[i][2]));
    }
}