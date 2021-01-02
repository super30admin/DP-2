# Time Complexity : O(coins * amount)
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# DP Problem


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for i in range(amount + 1):
                if i >= coin:
                    dp[i] += dp[i - coin]
            print(dp)
        return dp[-1]
