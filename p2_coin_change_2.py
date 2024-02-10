class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == 0:
            return 0
        matrix = [0 for _ in range(amount + 1)]
        matrix[0] = 1
        for i in range(1, len(coins) + 1):
            for j in range(0, amount+1):
                if j < coins[i-1]:
                    matrix[j] = matrix[j]
                else:
                    matrix[j] = matrix[j] + matrix[j- coins[i-1]]
        return matrix[amount]
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         if len(coins) == 0:
#             return 0
#         matrix = [[0 for _ in range(amount + 1)] for _ in range(0, len(coins) + 1)]
#         matrix[0][0] = 1
#         for i in range(1, len(matrix)):
#             for j in range(0, len(matrix[0])):
#                 if j < coins[i-1]:
#                     matrix[i][j] = matrix[i-1][j]
#                 else:
#                     matrix[i][j] = matrix[i-1][j] + matrix[i][j - coins[i-1]]
#         return matrix[len(coins)][amount]
    
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         rem = amount
#         self.res = 0
#         self.index = 0 
#         self.helper(self.index, coins, rem)
#         return self.res
    
#     def helper(self, index, coins, rem_amount):
#         # Base 
#         if rem_amount == 0:
#             self.res += 1
#             return 
#         if rem_amount < 0 or index == len(coins):
#             return 
#         # Logic
#         # Choose
#         self.helper(index, coins, rem_amount - coins[index])
#         # Not choose 
#         self.helper(index+1, coins, rem_amount)