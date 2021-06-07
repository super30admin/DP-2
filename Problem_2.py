from typing import List

# recursive Solution
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         if coins == None or len(coins) == 0:
#             return 0
#         return self.helper(amount, coins, 0) 
    
#     def helper(self, amount: int, coins: List[int], index: int) -> int:
#         # base
#         if amount == 0:
#             return 1
#         if amount < 0 or index == len(coins):
#             return 0
        
#         # don't choose
#         case1 = self.helper(amount, coins, index + 1)
        
#         # choose
#         case2 = self.helper(amount - coins[index], coins, index)
        
#         return case1 + case2

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None or len(coins) == 0:
            return 0

        dp = [[0 for j in range(amount+1)] for i in range(len(coins) + 1)]
        dp[0][0] = 1

        # fill the first column
        for i in range(len(dp)):
            dp[i][0] = 1

        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j- coins[i-1]]

        return dp[len(dp)-1][len(dp[0])-1]

obj = Solution()
print(obj.change(5, [1,2,5]))
print(obj.change(11, [1,2,5]))
print(obj.change(3,[2]))
print(obj.change(10,[10]))

# Time Complexity: n * m where n is len of coin array and m is amount
# Space Complexity: n * m where n is len of coin array and m is amount


