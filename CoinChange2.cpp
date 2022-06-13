// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode.

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1));
        int m = coins.size();
        int n = amount;
        // Below is not required since default value in a vector is zero when declared in the above manner.
        // for(int k = 1; k < dp[0].size(); k++){
        //     dp[0][k] = 0;
        // }
        dp[0][0] = 1;
        
        for(int i = 1; i < dp.size(); i++){
            for(int j = 0; j < dp[0].size(); j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        
        return dp[m][n];
    }
};
