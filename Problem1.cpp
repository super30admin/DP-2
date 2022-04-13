//Time Complexity : o(n*m)
//space Complexity : o(n*m)
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        return helper(coins,amount);
    }
    
     int helper(vector<int>& coins, int amount) {
        int dp[coins.size() + 1][amount + 1];
        
        for(int j =0;j<amount+1;j++){
            dp[0][j] = 0;;
        }
        
        for(int i =0;i<coins.size() + 1;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<coins.size() + 1;i++) {
            for(int j=1;j<amount+1;j++) {
                
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; 
                }
            }
        }
        
        return dp[coins.size()][amount];
    }
};