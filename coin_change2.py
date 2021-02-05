# O(A * C) TIME AND O(A) SPACE WHERE C IS NO.OF COINS AND A IS AMOUNT
class Solution:
    def change(self, amount,coins):
        dp = [0 for i in range(amount+1)]
        dp[0] = 1
        for coin in coins:
            for i in range(coin,amount+1):
                dp[i] += dp[i - coin]
        return dp[-1]