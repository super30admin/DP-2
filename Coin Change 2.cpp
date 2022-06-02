//Time Complexity- O(n*amount)
//Space Complexity- O(amount)

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        vector<int> dp(amount+1,0);
        dp[0]=1;
        
       for(int coin:coins){
           for(int c=coin;c<=amount;c++){
                   dp[c]+=dp[c-coin];
               }
           }
        return dp[amount];
    }
};