518. Coin Change II


TC O(nxm)
SC O(nxm)

class Solution {
public:

    int change(int amount, vector<int>& coins) {
         int m = coins.size();
        int n = amount;

        int dp[m+1][n+1];

        dp[0][0] = 0;
        for(int k=1; k <= n; k++) {
            dp[0][k] = 0;
        }        
        for(int k=1; k <= m; k++) {
            dp[k][0] = 1;
        }

        for(int i=1;i <= m; i++) {
            for(int j=1; j <= n; j++) {
                 if(j < coins[i-1]) {
                     dp[i][j] = dp[i-1][j];
                 } else {
                    dp[i][j] = dp[i-1][j] + (dp[i][j - coins[i-1]]);
                 }
            }
        }
        return dp[m][n]; 
        }       

};


TC O(nxm)
SC O(n)

class Solution {
public:

    int change(int amount, vector<int>& coins) {
         int m = coins.size();
        int n = amount;

        int dp[n+1];
        dp[0] = 1;
        for(int k=1; k <= n; k++) {
            dp[k] = 0;
        }
        for(int i=1;i <= m; i++) {
            for(int j=1; j <= n; j++) {
                 if(j >= coins[i-1]) {
                    dp[j] = dp[j] + (dp[j - coins[i-1]]);
                 }
            }
        }

        return dp[n]; 
        }

};

