/*
    Time complexity: O(N*target)
    Space complexity: O(N*target)
*/

class Solution {
public:
    vector<int> coins;
    vector<vector<int>> dp;

    int call(int amount, int pos){
      if(amount==0)  return 1;
      if(amount<0 || pos==coins.size())  return 0;

      if(dp[amount][pos]!=-1)  return dp[amount][pos];
      
      int ans = 0;

      ans += call(amount-coins[pos], pos); //option1 : take the current coin and proceed with the same coin
      ans += call(amount, pos+1); //option2: proceed with the next coin

      return dp[amount][pos] = ans;
    }

    int change(int amount, vector<int>& coins) {
        dp = vector(amount+1, vector(coins.size(), -1));
        this->coins = coins;

        return call(amount,0);
    }
};
