# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

# --------------------------DP Approach----------------------------
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == 0 or coins is None:
            return -1
        m = len(coins) + 1
        n = amount + 1
        dp = [[0] * n] * m
        for i in range(0, m):
            dp[i][0] = 1
            
        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m-1][n-1]


# -----------------------Exhaustive Approach-----------------------
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         if len(coins) == 0 or coins is None:
#             return -1
#         return self.helper(coins, amount, 0)
    
#     def helper(self, coins, amount, index):
#         if amount < 0 or index == len(coins): return 0
        
#         if amount == 0: return 1
        
#         case0 = self.helper(coins, amount, index + 1)
#         case1 = self.helper(coins, amount - coins[index], index )
        
#         if case0 == -1: return case1
#         if case1 == -1: return case0
#         return case0 + case1