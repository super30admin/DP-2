// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had to figure out how to use 128bit unsigned int, since the last testcase was always giving integer overflow despite using long long


// Your code here along with comments explaining your approach
// In this variation, dp[j] stores the number of ways we can make amount j
// We go over all the coins and pick(if possible) & no pick based on the denomination and the current amount, and add the 2 results and store it in dp[j]
// At the end, dp[amount] will contain the final answer of the total ways to make the amount using the coin denominations provided

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int m = coins.size();
        int n = amount;
        vector<unsigned __int128>dp(n+1, 0);
        dp[0] = 1;
        for(int i=1; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(coins[i-1] <= j){ 
                    dp[j] = dp[j] + dp[j - coins[i-1]]; // no pick + pick
                } else {
                    dp[j] = dp[j]; // no pick
                }
            }
        }
        return dp[n];
    }
};