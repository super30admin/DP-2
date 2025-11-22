# Time Complexity :O(mn)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
#I used a DP array where dp[i] stores the number of ways to make amount i.
# For each coin, I iterate through all amounts ≥ coin value and update dp[j] += dp[j - coin] to add combinations including this coin.
# At the end, dp[amount] contains the total number of combinations to form the target amount.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0]* (amount+1)
        dp[0] = 1
        if len(coins) == 0 or amount < 0:
            return 0
        for coin in coins:
            for j in range(coin,amount+1):
                dp[j] = dp[j]+ dp[j-coin]
        return dp[amount]