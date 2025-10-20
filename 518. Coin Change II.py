# Time: O(2^m+n) => m is the amount and n is the no. of elements in coins array
# The time complexity is when we choose until amount is 1 and then we don't choose until the idx is not out of range
# Space: O(m+n) => That's the recursive space that will be used at the end

# Everything is similar to coin change except returning choose + not_choose because we have to count all the possible paths
# Hence we have also changes the base cases accordingly so if amount is 0 it's valid and returns 1 and rest is invalid path which returns 0
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(coins, amount, 0)
    def helper(self,coins,amount,idx):
        # Base case
        if amount == 0:
            return 1
        if idx > (len(coins) - 1) or amount < 0:
            return 0

        # choose
        choose = self.helper(coins,amount-coins[idx],idx)
        # Not choose
        not_choose = self.helper(coins,amount,idx+1)

        return choose + not_choose
    
# MEMOIZATION SOLUTION
# Time and Space: O(m * n) where m is the len(coins) and n is the amount

# Just add the values calculate (choose + not_choose) in a memo matrix and use the same amount for repeated sub problems
# Add the result in the memo matrix i.e the additioin of choose and not_choose
# return self.memo[idx][amount] from the function 
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        self.memo = [[-1 for _ in range(amount + 1)] for _ in range(len(coins) +1)] 

        return self.helper(coins, amount, 0)
    def helper(self,coins,amount,idx):
        # Base case
        if amount == 0:
            return 1
        if idx > (len(coins) - 1) or amount < 0:
            return 0
        if self.memo[idx][amount] != -1:
            return self.memo[idx][amount]

        # choose
        choose = self.helper(coins,amount-coins[idx],idx)
        # Not choose
        not_choose = self.helper(coins,amount,idx+1)

        self.memo[idx][amount] = choose + not_choose
        return self.memo[idx][amount]
    

# TABULARISATION SOLUTION
# Time and Space: O(m * n) where m is the len(coins) and n is the amount
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows = len(coins)
        cols = amount
        dp_matrix = [[0 for _ in range(cols + 1)] for _ in range(rows + 1)]

        for i in range(1,rows + 1):
            for j in range(0,cols + 1):
                if j == 0:
                    dp_matrix[i][j] = 1
                elif j < coins[i-1]:
                    dp_matrix[i][j] = dp_matrix[i - 1][j]
                else:
                    dp_matrix[i][j] = dp_matrix[i - 1][j] + dp_matrix[i][j-coins[i - 1]]

        return dp_matrix[rows][cols]
