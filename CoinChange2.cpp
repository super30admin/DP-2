//Time Complexity:O(mxn)
// Space Complexity: O(mxn)

class Solution {
public:
    int change(int amount, vector<int>& coins) {

        int m = coins.size();
        int n = amount;

        int dp[m+1][n+1];

        for(int i = 1; i<= m; i++)
        {
            for(int j = 0; i<=n; j++)
            {
                if(j <= coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }                
            }
        }
        return dp[m][n];        
    }
};