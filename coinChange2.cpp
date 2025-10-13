/* ################################################## Recursive Solution ################################################## */

class Solution {
public:
    int helper(int amount, vector<int>& coins, int idx)
    {
        if (idx >= coins.size() || amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        int result = 0;
        result += helper(amount - coins[idx], coins, idx);
        result += helper(amount, coins, idx + 1);

        return result;
    }
    int change(int amount, vector<int>& coins)
    {
        return helper(amount, coins, 0);
    }
};


/* ################################################## DP Solution ################################################## */


class Solution {
public:
    void helper(vector<unsigned>& dp)
    {
        for (int i = 1; i < dp.size(); i++) {
            dp[i] = 0;
        }

        dp[0] = 1;
    }
    int change(int amount, vector<int>& coins)
    {
        vector<unsigned>dp(amount + 1, 0);
        helper(dp);
        
        for (int i = 1; i <= coins.size(); i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] += dp[j - coins[i - 1]];
            }
        }

        return dp[amount];
    }
};
