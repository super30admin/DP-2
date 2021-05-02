/*
Time complexity = O(nk) // n - number of coins, k - amount
Space complexity = O(nk)
*/
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if (coins.size() == 0) return 0;
        int rows = coins.size();
        vector<vector<int>> dp(rows + 1, vector<int>(amount + 1, 0));
        for (int i = 1; i <= rows; ++i) dp[i][0] = 1;
        for (int i = 1; i <= rows; ++i){
            for (int j = 1; j <= amount; ++j){
                if (j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j] + (dp[i][j - coins[i - 1]] == 0 ? 0 : dp[i][j - coins[i - 1]]);
                }
            }
        }
        return dp[rows][amount];
    }
};