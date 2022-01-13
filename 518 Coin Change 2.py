class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == None: return 0 
        dp = [[0] * (amount + 1) for i in range(len(coins) + 1)]
        print(dp)
        for j in range(1, len(coins) + 1):
              dp[j][0] = 1
              
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]]
        return dp[len(coins)][amount]
    
    
# T.C => O(len(coins) * amount)
# S.C => O(len(coins) * amount)
# Approach => Storing the previous computations in a DP and then using them to calculate the 
#total. Setting the dp array from length of coins + 1 and amount  + 1. We are computing if the value are indp array or not to calculate the count and ways to reach there.