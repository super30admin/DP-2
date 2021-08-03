// Time Complexity : O(MN)
// Space Complexity :O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(coins.empty() || coins.size() == 0){
            return 0;
        }
        vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1));
        for(int i=0; i<coins.size()+1; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<amount+1; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<dp.size(); i++){
            for(int j=1; j<dp[0].size(); j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        return dp[dp.size()-1][dp[0].size()-1];
    }
};
