// TC - O(MN)
// SC - O(M)

// Constraints:
// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// All the values of coins are unique.
// 0 <= amount <= 5000

public class CoinChangeAllCombinationsToAmountSingleArrayDP {
    class Solution {
        public int change(int amount, int[] coins) {
            // Matrix stores the number of ways an amount can be formed with given number of
            // coins
            int[] matrix = new int[amount + 1];

            matrix[0] = 1; // Whenever amount=0, add 1
            for (int j = 1; j <= amount; j++) {
                matrix[j] = 0;
            }

            for (int i = 1; i <= coins.length; i++) {
                for (int j = 0; j <= amount; j++) {
                    // if (j < coins[i - 1]) {
                    //     matrix[j] = matrix[j];
                    // } else {
                    //     matrix[j] = matrix[j] + matrix[j - coins[i - 1]];
                    // }

                    if (j >= coins[i - 1]) {
                        matrix[j] = matrix[j] + matrix[j - coins[i - 1]];
                    }
                }
            }

            return matrix[amount];
        }
    }
}