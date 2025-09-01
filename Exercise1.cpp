// Problem - Coin Change 2
//  Time Complexity : O(m*n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we use 1D DP dp[j] array which tells the number of ways we can make
// the amount j
// 2. If we reach a coin denomination which is smaller or equal to amount then
// only we add the ways otherwise skip it
// 3. In the end we return dp[n] which holds the number of combinations to make
// the target amount

#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  int change(int amount, vector<int> &coins) {
    int m = (int)coins.size();
    int n = amount;
    vector<double> dp(n + 1, 0);
    dp[0] = 1;

    for (int i = 1; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (coins[i - 1] <= j) {
          dp[j] = dp[j] + dp[j - coins[i - 1]];
        }
      }
    }

    return dp[n];
  }
};
