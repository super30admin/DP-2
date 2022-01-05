class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        int dp[amount+1];
        memset(dp, 0, sizeof(dp));
        dp[0] = 1;
        
        for(auto coin:coins){
        for(int i=1;i<=amount;i++){
                if(i-coin>=0 && i<=amount) {
                    dp[i] +=  dp[i-coin];
                }                    
            }            
        }
        
        for(auto i: dp)
        {
            cout<<i<< " ";
        }
        cout<<endl;
        
        
        return dp[amount];
    }
    
};
