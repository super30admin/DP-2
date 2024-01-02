/*
 * Time Complexity : O(n*amount)
 * Space Complexity : O(amount)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

// ! Tabulation (Bottom-up Approach)

class Solution {
public:
    int change(int amount, std::vector<int>& coins) {
        std::vector<int> dp(amount + 1, 0);
        dp[0] = 1; //base case
        int n = coins.size();

        for (int coin : coins) {
            for (int curr_amount = coin; curr_amount <= amount; curr_amount++) {
                dp[curr_amount] += dp[curr_amount - coin];
            }
        }

        return dp[amount];
    }
};


// ! Recursion with memoization (Top-down Approach)

// class Solution {
//     int helper(int idx, std::vector<int>& coins, int amount, std::vector<std::vector<int>>& memo) {
//         // base
//         if (amount == 0)
//             return 1;
//         if (amount < 0 || idx == coins.size())
//             return 0;
//         if (memo[idx][amount] != -1)
//             return memo[idx][amount];

//         // logic
//         // choose
//         int choose = helper(idx, coins, amount - coins[idx], memo);

//         // not choose
//         int not_choose = helper(idx + 1, coins, amount, memo);

//         // storage
//         memo[idx][amount] = choose + not_choose;

//         return memo[idx][amount];
//     }
// public:
//     int change(int amount, std::vector<int>& coins) {
//         std::vector<std::vector<int>> memo(coins.size(), std::vector<int>(amount + 1, -1));
//         return helper(0, coins, amount, memo);
//     }
// };