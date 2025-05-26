// Time complexity O(m*n)
// Space complexity O(m*n)
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int m = coins.size();
        int n = amount;
        
        vector<vector<double>> memo(m+1, vector<double>(n+1, 0));
        memo[0][0] = 1;

        for (int i=1; i <=m; i++) {
            for (int j=0; j <=n; j++) {
                if (j < coins[i-1]) {
                    memo[i][j] = memo[i-1][j];
                } else {
                    memo[i][j] = memo[i-1][j] + memo[i][j-coins[i-1]];
                }
            }
        }

        return memo[m][n];
    }
};