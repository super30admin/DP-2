# TC: O(n * amount)
# SC : O(amount)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None:
            return 0
        m = len(coins)
        n = amount
        dp = [0] * (amount + 1)
        dp[0] = 1

        for i in range(1, m+1):
            for j in range(0, n+1):
                if j >= coins[i-1]:
                    dp[j] = dp[j] + dp[j - coins[i-1]]
        return dp[n]