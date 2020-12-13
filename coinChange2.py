# Apporach1: Same as Coin change 1 problem. We will use the same recurssive procedure with change in logic
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:        
#         return self.helper(coins, amount, 0)
    
#     def helper(self, coins, amount, index):
        
#         if amount == 0:
#             return 1
#         if amount < 0 or index == len(coins):
#             return 0
        
#         # Logic
#         # Choose
#         case1 = self.helper(coins, amount-coins[index], index)
#         case2 = self.helper(coins, amount, index + 1)
        
#         return case1 + case2
   
    
# Approach2: 
# Same as Coin change problem but this time we store sum of all the ways target can be formed
# We will make a 2D matrix that will hold the intermediate total ways for every case. It will store a value ways that a target can be achieven with that particular number of denominations 
# Those value will be used ahead in the program to save computation.

# rows shows denominations avaliable upto that point
# column shows target value that should be achieved
# a value in a cell shows that how many ways are there to achieve the target value at the column
# For example cell[2][2] shows that it will take only one coin out of denominaitons 1,2 two achieve target vaue of 2

#       0   1   2        3   4   5   6   7   8   9   10  11
#   0   1   0   0        0   0   0   0   0   0   0   0   0   
#   1   1   1   2        3   4   5   6   7   8   9   10  11 
#   2   1   1   1+1=2 
#   5   1
 
# Case 1: Target value to be achieved is less than the coin denominations we have available
# Case 2: Target value to be achieved is more than the coin denominations we have available
# General formula to calculate value at each cell is:
#           ways to acheive target if the denomination is not choosen(value of the cell above the current cell)
#       + ways in which remaining target value can be acheived after the coin is choosen 

# Time Complexity: (m*n), m = no of rows of dp, n = no of columns of dp
# Space complexity: O(1)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:   
        rows = len(coins) + 1
        cols = amount + 1
        
        dp = [[0 for i in range(cols)] for j in range(rows)]
            
        for r in range(rows):
            dp[r][0] = 1
            
        for i in range(1, rows):
            for j in range(1, cols):
                
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]     
        
        return dp[rows-1][cols-1]