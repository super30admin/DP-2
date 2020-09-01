//M : Coins size
//N : Amount
//T : O(M*N)
//S: O(M*N)
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(amount == 0) return 1;
        int m = coins.size()+1;
        int n = amount+1;
        
        vector<vector<int>> dp( m, vector<int>(n, 0));
        //Special case where - for amount zero, with any coins can be made in 1 way
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j - coins[i-1]];
                }
            }
        }
        
        
        return dp[m-1][n-1];
    }
};