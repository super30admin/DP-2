// TC - O(2^(M-1+N))
// SC - O(2^(M-1+N))

// Constraints:
// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// All the values of coins are unique.
// 0 <= amount <= 5000

public class CoinChangeAllCombinationsToAmountRecursion {
    class Solution {
        // private int count = 0;

        public int change(int amount, int[] coins) {
            return helper(coins, amount, 0);
        }

        // private void helper(int[] coins, int amount, int index) {
        //     if (amount == 0) {
        //         count++;
        //         return;
        //     }
        //     if (amount < 0 || index >= coins.length) {
        //         return;
        //     }
        //     helper(coins, amount - coins[index], index);
        //     helper(coins, amount, index + 1);
        // }

        private int helper(int[] coins, int amount, int index) {
            if (amount == 0) {
                return 1;
            }
            if (amount < 0 || index >= coins.length) {
                return 0;
            }
            int waysCurrCoinTaken = helper(coins, amount - coins[index], index);
            int waysCurrCoinNotTaken = helper(coins, amount, index + 1);

            return waysCurrCoinTaken + waysCurrCoinNotTaken;
        }
    }

}