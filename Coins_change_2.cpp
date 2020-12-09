// Time Complexity :O(N*amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>>dp(coins.size()+1, vector<int>(amount+1));
        int m = dp.size();
        int n = dp[0].size();
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i =1; i<m;i++){
            for(int j=1;j<n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m-1][n-1];
    }
};
