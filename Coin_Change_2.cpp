class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int m =coins.size(), n=amount;
        vector<vector<int>> dp(m+1, vector<int>(n+1));
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
     return dp[m][n];   
    }
};

// we can further improve the space complexity by using an array of dp instead of using a 2d array of dp, as we can update it and res use it so that our space complexity will be O(n) instead of      O(m X n). The time complexity is gonna be O(m X n) only;
