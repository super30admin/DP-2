# Problem2 (https://leetcode.com/problems/coin-change-2/)
# Time Complexity: O(m * n), we have two nested loops, outer loop runs m times (once per coin), inner loop runs up to n times (once per amount), so total work is m times n
# Space Complexity: O(n),we only use a single 1D dp array of size n plus 1, no extra data structures that grow with input
# Approach: build a 1D dp array where dp[j] means the number of ways to make amount j. Process coins one at a time (outer loop) instead of amounts one at a time, since this order counts combinations and not permutations. For each coin, update every amount that is at least as big as the coin by adding in the ways that come from using one more of that coin.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)    # m is how many different coin types we have, used to control how many times the outer loop runs
        n = amount    # n is the target amount, used to size the dp array and control the inner loop

        dp = [0]*(n+1)     # dp[j] will hold the number of ways to make amount j, one slot for every amount from 0 to n
        dp[0] = 1          # base case, there is exactly one way to make amount 0, which is picking no coins at all
        # this seed value is what every other count gets built from

        for i in range(1, m+1):
            # outer loop, goes coin type by coin type, one coin gets allowed at a time
            # using 1 to m here instead of 0 to m-1, so coins[i-1] is used below to fix the offset
            for j in range(coins[i-1], n+1):
                # inner loop, only touch amounts j that are at least as big as the current coin
                # starting here instead of 0 avoids using a coin bigger than the amount, which would give an invalid negative index below
                dp[j] += dp[j - coins[i-1]]
                # dp[j - coins[i-1]] is the number of ways to make the smaller amount before adding this coin
                # adding one more of this coin to each of those ways gives new ways to make j
                # this adds onto dp[j]'s existing value rather than replacing it, so ways found using earlier coins are kept

        return dp[n]
        # after allowing all coin types, dp[n] holds the total number of combinations that make the full amount
        