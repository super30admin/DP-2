// Time Complexity                              :  O(N*AMOUNT)
// Space Complexity                             :  O(N*AMOUNT)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<int>> dp(n+1,vector<int>(amount+1,0));
        
        // there is only 1 way to generate amount = 0 with any coin which is to not pick that coin.
        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=amount;j++) {
                if(j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount];
    }
    
};