

# =============================================================================
# Approach 1: Recursion (choose / don't choose)
# =============================================================================
# Approach:
#   At each coin index we have two options. Skip the coin and move to the next
#   index, or take the coin and stay on the same index (coins can be reused).
#   When the amount hits 0 we found one valid combination; when the amount goes
#   negative or we run out of coins, that path is dead. Adding both branches
#   counts every combination exactly once because the coin order is fixed by
#   the index.
#
# Time Complexity : O(2^(m + n)) - m = number of coins, n = amount. The same
#                   (idx, amount) subproblems are recomputed many times.
# Space Complexity : O(n) - recursion stack, worst case amount n with coin 1
# Did this code successfully run on Leetcode : No, Time Limit Exceeded on
#                   larger inputs (needs memoization on (idx, amount))
# Any problem you faced while coding this : Overlapping subproblems
from __future__ import annotations
class SolutionRecursive:
    def change(self, amount: int, coins: list[int]) -> int:
        if coins is None or len(coins) == 0:
            return 0
        return self.helper(amount, coins, 0)

    def helper(self, amount: int, coins: list[int], idx: int) -> int:
        # base case
        if idx >= len(coins) or amount < 0:
            return 0
        if amount == 0:
            return 1

        # logic
        # don't choose the current coin
        dont_choose = self.helper(amount, coins, idx + 1)
        # choose the current coin (stay on idx, coin can be reused)
        choose = self.helper(amount - coins[idx], coins, idx)

        return choose + dont_choose


# =============================================================================
# Approach 2: 2D DP (bottom-up)
# =============================================================================
# Approach:
#   dp[i][j] = number of ways to make amount j using only the first i coins.
#   Column 0 is 1 for every row, since there is exactly one way to make
#   amount 0 (use nothing). If coins[i-1] is bigger than j we cannot use it, so
#   we copy dp[i-1][j]. Otherwise we add the ways without this coin,
#   dp[i-1][j], to the ways with this coin, dp[i][j - coin] (same row, because
#   the coin can be reused). The answer is the bottom-right cell.
#
# Time Complexity : O(m * n) - each cell is filled once in O(1)
# Space Complexity : O(m * n) - for the 2D table
# Did this code successfully run on Leetcode : Yes (standard DP solution)
# Any problem you faced while coding this : Row indexing. dp has m+1 rows but
#                   coins is 0-indexed, hence coins[i-1]
class Solution2D:
    def change(self, amount: int, coins: list[int]) -> int:
        if coins is None or len(coins) == 0:
            return 0
        m = len(coins)
        n = amount
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for i in range(m + 1):
            dp[i][0] = 1
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[m][n]


# =============================================================================
# Approach 3: 1D DP (space optimized)
# =============================================================================
# Approach:
#   Row i of the 2D table only depends on row i-1 and on earlier cells of row i,
#   so one array is enough. Updating dp[j] in place keeps its old value as the
#   "skip this coin" case, and dp[j - coin] has already been updated for this
#   coin, which gives the "reuse this coin" case. The coin loop must stay on the
#   outside and the amount loop on the inside. Swapping them would count
#   permutations (1+2 and 2+1 as different) instead of combinations.
#
# Time Complexity : O(m * n) - m = number of coins, n = amount
# Space Complexity : O(n) - a single array of size amount + 1
# Did this code successfully run on Leetcode : Yes (optimal standard solution)
# Any problem you faced while coding this : Loop order (coins outer, amount
#                   inner). Also dp[j] = dp[j] is a no-op, so the else-only
#                   form below (start j at coin) is cleaner.
class Solution:
    def change(self, amount: int, coins: list[int]) -> int:
        if coins is None or len(coins) == 0:
            return 0
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] += dp[j - coin]
        return dp[amount]


# =============================================================================
# Test cases
# =============================================================================
if __name__ == "__main__":
    # (amount, coins, expected)
    tests = [
        (5, [1, 2, 5], 4),   # LeetCode example 1: 5, 2+2+1, 2+1+1+1, 1*5
        (3, [2], 0),         # LeetCode example 2: impossible
        (10, [10], 1),       # LeetCode example 3: single coin matches
        (0, [1, 2], 1),      # amount 0: one way (use nothing)
        (5, [7], 0),         # coin larger than amount
        (4, [1, 2, 3], 4),   # 1111, 112, 22, 13
        (7, [2, 4], 0),      # odd amount with only even coins
        (8, [3, 5, 1], 5),   # unsorted coins; order must not matter
        (6, [1, 2], 4),      # 1*6, 2+1*4, 2+2+1+1, 2+2+2
    ]

    # Large case: only the DP versions can handle it (recursion would hang)
    large_test = (500, [1, 2, 5], 12701)

    solutions = [SolutionRecursive(), Solution2D(), Solution()]

    for sol in solutions:
        for amount, coins, expected in tests:
            got = sol.change(amount, coins)
            assert got == expected, (
                f"{type(sol).__name__} failed: amount={amount}, "
                f"coins={coins}, got={got}, expected={expected}"
            )
        print(f"{type(sol).__name__}: passed all {len(tests)} tests")

    amount, coins, expected = large_test
    for sol in solutions[1:]:
        got = sol.change(amount, coins)
        assert got == expected, (
            f"{type(sol).__name__} failed large test: got={got}, expected={expected}"
        )
        print(f"{type(sol).__name__}: passed large test (amount={amount})")