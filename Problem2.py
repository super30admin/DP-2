#Time complexity : O(amount)
#Space complexity : O(amount)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0]*(amount+1)
        dp[0] = 1
        for j in coins:
            for i in range(j,amount+1):
                dp[i] += dp[i-j]
        return dp[amount]