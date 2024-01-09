// Time Complexity : O(N*M)

// Space Complexity : O(N*M)

// Did this code successfully run on Leetcode : YES

// Appoarch: First solved it using recursion, the did tabulation
// to avoid TLE and avoid using stack space for dp.

// 518. Coin Change II

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<long>> dp(n, vector<long>(amount+1,0));
        for(int T=0;T<=amount;T++){
            dp[0][T] = (T%coins[0] == 0);
        }
        for(int idx = 1;idx<n;idx++){
            for(int Target = 0;Target<=amount;Target++){
                long notTake = dp[idx-1][Target];
                long take = 0;
                if(coins[idx] <= Target){
                    take = dp[idx][Target - coins[idx]];
                }
                dp[idx][Target] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }
};