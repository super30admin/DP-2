# Time Complexity: O(N*K) where n is the coins and k is the amount
# Space Complexity: O(K)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
      # dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins) + 1)]
      # dp[0][0] = 1 # 1 way to make zero

      # for i in range(1, len(coins)+1):
      #   for amt in range(amount + 1):
      #     if amt == 0:
      #       dp[i][amt] = 1
          
      #     if amt < coins[i-1]:
      #       dp[i][amt] = dp[i-1][amt]
      #     else:
      #       dp[i][amt] = dp[i-1][amt] + dp[i][amt - coins[i-1]]
        
      
      # return dp[-1][amount]

      dp = [0] * (amount + 1)
      dp[0] = 1

      for i in range(len(coins)):
        for amt in range(amount + 1):
          if amt < coins[i]:
            dp[amt] = dp[amt]
          else:
            dp[amt] = dp[amt] + dp[amt - coins[i]]
      
      return dp[amount]

