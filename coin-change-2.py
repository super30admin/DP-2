#A little confused, but I think I got the idea about how to approach any DP problem.

# TC: O(coins*amount)
# SC: o(amount)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[0]*(amount+1)
        dp[0]=1
        
        for coin in coins:
            for x in range(coin,amount+1):
                dp[x]+=dp[x-coin]
        return dp[amount]