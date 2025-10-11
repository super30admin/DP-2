import java.util.Arrays;

/**
 * Leet Code : https://leetcode.com/problems/coin-change-ii/description/
 *
 * Approach:
 * This solution uses top-down dynamic programming (recursion with memoization) to count the number of ways
 * to make up a given amount using the provided coin denominations. At each step, we decide whether to pick
 * the current coin (and stay at the same index, since coins can be reused) or skip it (move to the next index).
 *
 * - The memoization table (memo) stores results for subproblems defined by the current coin index and remaining amount.
 * - Base cases:
 *   - If the remaining amount is 0, we've found a valid combination (return 1).
 *   - If we've exhausted all coins or the remaining amount is negative, no valid combination (return 0).
 * - For each subproblem, we check if the result is already computed in memo. If not, we compute it recursively.
 *
 * Time Complexity: O(n * amount), where n is the number of coins.
 * Space Complexity: O(n * amount) for the memoization table.
 */
public class CoinChangeII {
    // memo[i][j] stores the number of ways to make up amount j using coins from index i onwards
    private int[][] memo;

    public int change(int amount, int[] coins) {
        // Initialize memoization table with -1 (uncomputed)
        memo = new int[coins.length][amount + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        // Start recursion from index 0 and the full amount
        return helper(coins, 0, amount);
    }

    public int helper(int[] coins, int idx, int remain) {
        // Base case: if remaining amount is 0, found a valid combination
        if (remain == 0) return 1;
        // Base case: if out of coins or negative amount, no valid combination
        if (idx == coins.length || remain < 0) return 0;

        // Check if result is already computed
        if (memo[idx][remain] != -1) return memo[idx][remain];

        // Choice 1: Do not pick the current coin, move to next coin
        int notPick = helper(coins, idx + 1, remain);
        // Choice 2: Pick the current coin, stay at same index (since coins can be reused)
        int pick = helper(coins, idx, remain - coins[idx]);
        // Store result in memo table
        memo[idx][remain] = notPick + pick;

        return memo[idx][remain];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeII().change(5, new int[]{1, 2, 5}));
    }
}
