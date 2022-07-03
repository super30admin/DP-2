//tc(O(n*m)
//sc-O(n*m)
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
    if(coins.size()==0||amount==0)return 1;
        
        
        int m=coins.size();
        int n=amount;
        vector<vector<int>>dp(m+1,vector<int>(n+1));
        
        for(int j=1;j<n+1;j++){
            dp[0][j]=0;
        }
        for(int i=0;i<m+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1]){//amount to be formed is lesser than the change we are holding
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
};