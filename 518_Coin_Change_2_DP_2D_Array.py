# Time Complexity : O(n * k) [n = number of coins, k = amount]
# 
# Space Complexity : O(n * k) [n = number of coins, k = amount]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
#
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [[0 for col in range(amount+1)] for row in range(len(coins)+1)]
        
        # we can make the amount 0 by not choosing any of the coin(only 1 way)
        # so we mark the first column as 1        
        for i in range(len(coins)+1):
            dp[i][0] = 1
        
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]] # Number of possible ways of reaching the amount j provided we select the coin[i-1]
        return dp[len(coins)][amount]