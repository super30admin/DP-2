// Time Complexity : O(N*3) => O(N)

// Space Complexity : O(N*3) => O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: First solved it using recursion, the did tabulation
// to avoid TLE and avoid using stack space for dp.

// 256. Paint House

#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        vector<vector<int>> dp(n,vector<int>(3));
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];
        for(int idx = n-2;idx>=0;idx--){
                dp[idx][0] = costs[idx][0] + min(dp[idx+1][1],dp[idx+1][2]);
                dp[idx][1] = costs[idx][1] + min(dp[idx+1][0],dp[idx+1][2]);
                dp[idx][2] = costs[idx][2] + min(dp[idx+1][0],dp[idx+1][1]);
        }
        return min(dp[0][0],min(dp[0][1],dp[0][2]));
    }
};