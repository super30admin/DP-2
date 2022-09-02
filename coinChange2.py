# # Recursive solution

# # Time Complexity: O(2^n) ~ Exponential

# # Space Complexity: 

# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         return self.helper(coins, 0, amount)
    
#     def helper(self, coins: List[int], index: int, amount: int) -> int:
        
        
# #         Base Case
#         if amount == 0:
#             return 1
        
#         if ((amount < 0) or (index == len(coins))):
#             return 0
        
# #         Choose or Not Choose
        
#         case1 = self.helper(coins, index, amount - coins[index])
#         case2 = self.helper(coins, index + 1, amount)
        
#         return (case1 + case2)


# DP Solution

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        m = amount
        if coins is None or n < 1:
            return 0

        dp = [[0 for i in range(0, amount + 1)] for i in range(0, n + 1)]
        dp[0][0] = 1
        
        for i in range(1, len(dp)):
            for j in range(len(dp[0])):
                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        
        return dp[n][m]
