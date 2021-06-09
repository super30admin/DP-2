// Time Complexity : O(n^2)
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : Couldn't try, don't have Premium
// Any problem you faced while coding this : No

// Coin Change 2 

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> dp(coins.size() + 1 , vector<int> (amount + 1));
        dp[0][0] = 1;

        for(int i = 0; i < dp.size(); i++){
            dp[i][0] =1 ;
        }

        for(int i = 1; i < dp.size(); i++){
            for(int j = 1; j < dp[0].size(); j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[dp.size() - 1][dp[0].size() -1];
    }
};