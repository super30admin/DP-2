//Problem2 (https://leetcode.com/problems/coin-change-2/)
// Time Complexity : O(m*n) where m is the size of coins array and n is the amount
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int m = coins.size();
        int n = amount;
        
        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        
        for(int i=1;i<m+1;i++){
            dp[i][0] = 1;
        }
        
        for(int j=0;j<n+1;j++){
            dp[0][j] = 0;
        }
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[m][n];
        
    }
};