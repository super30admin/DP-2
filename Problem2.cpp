// Time Complexity : O(M*amount) m is # of denominations
// Space Complexity : O(M*amount)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Similar to coin-change-1 but don't take minimum. 
// 2. Add ways if we select denomination and if we don't.

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n=coins.size();
        long long dp[n+1][amount+1];
        for(int i=0;i<=amount;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                
                if(j==0){
                    dp[i][j]=1;
                    cout<<dp[i][j]<<'\n';
                    continue;
                }
                int max=dp[i-1][j];
                if( (j-coins[i-1]) >= 0 ){
                    dp[i][j]=max+dp[i][j-coins[i-1]];
                    //cout<<dp[i][j]<<'\n';
                    continue;
                }
                dp[i][j]=max;
                //cout<<dp[i][j]<<'\n';
            }
        }
        return dp[n][amount];
    }
};