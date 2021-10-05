// It is a Dynamic programming Problem. Each cell of the DP table represents the numner of ways a particular amount can be made.
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int m = coins.size()+1;
        int n = amount + 1;
        int dp [m][n];
        
        // Filling up Row 
        for(int i=1; i<n; i++){
            dp[0][i] = 0;
        }
        
        // Filling up Column 
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        
        // Filling DP Table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if( coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
};

// Time Complexity: O(n^2) 
// Space Complexity: o(n^2)
