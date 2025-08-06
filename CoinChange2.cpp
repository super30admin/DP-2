#include<iostream>
#include<vector>
using namespace std;
/*
We build a 1D dp array where each dp[j] tells us the number of ways to make amount j.
For every coin, we go through all amounts from that coin’s value up to the target and update dp[j] by adding dp[j - coin].
In the end, dp[amount] holds the total number of combinations to make the target amount using all coins
*/
class Solution{
public:
    int change(int amount, vector<int>& coins) {
        int m = coins.size();
        int n = amount;

        vector<int> dp(n + 1, 0);
        dp[0] = 1;

        for(int i = 1; i <= m; i++){
            for(int j = coins[i - 1]; j <= n; j++){
                dp[j] += dp[j - coins[i - 1]];
            }
        }

        return dp[n];
    }
};
