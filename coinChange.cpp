class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> memo(coins.size(), vector<int>(amount + 1, -1));
        return dp(amount, coins, 0, memo); 
    }

private:
    int dp(int amount, vector<int>& coins, int idx, vector<vector<int>>& memo) {
        if (idx == coins.size()) return 0;
        if (amount == 0) return 1;
        if (memo[idx][amount] != -1) return memo[idx][amount];

        int doNotTake = dp(amount, coins, idx + 1, memo);
        int take = 0;
        if (amount >= coins[idx]) take = dp(amount - coins[idx], coins, idx, memo);
        return memo[idx][amount] = take + doNotTake;
    }
};