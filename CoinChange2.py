# DP 
# TC : O(m*n) ; m = 1 + number of coins , n = 1 + amount
# SC : O(m*n) 
# Approach : We build our table iteratively. First we fill [j][0] for all rows, as there is only one way to reach
# 0 that is not selecting that coin. Now, if amount is less than current coin, then simply copy the previous [row][col]
# data, else add the difference of amount and current coin's value to previous sum to indicate we found more combination.
# Our answer lies in last row, last column, if it is 0, means no ways found, else vice-versa.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins and amount == 0:
            return 1
        elif not coins:
            return 0
        
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]
        
        m = len(dp)
        n = len(dp[0])
        
        for j in range(m):
            dp[j][0] = 1
            
        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
                    
        return dp[m - 1][n - 1] if dp[m - 1][n - 1] != 0 else 0
    

# Recursive : Time Limit Exceeded
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         if not coins and amount == 0:
#             return 1
#         elif not coins:
#             return 0
        
#         return self.helper(coins, amount, 0)
    
#     def helper(self, coins, amount, index):
#         # Base
#         if amount == 0:
#             return 1
#         if amount < 0 or index == len(coins):
#             return 0
        
#         # Logic
#         # Choose coin
#         case1 = self.helper(coins, amount - coins[index], index)
#         # Don't choose coin
#         case2 = self.helper(coins, amount, index + 1)
        
#         return case1 + case2