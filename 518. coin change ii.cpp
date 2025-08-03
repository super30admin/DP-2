class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int m = coins.size();
        int n = amount;

        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        dp[0][0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
};
/*********dp with 1d array */
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n = amount;
        vector<long long> dp(n + 1, 0);  // Use long long
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[n];
    }
};
