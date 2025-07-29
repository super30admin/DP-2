# recurrsive approach
# Time Complexity: O(2^m*n)

class Solution:
    def change(self, amount: int, coins: list[int]) -> int:
        if coins == None or len(coins) == 0:
            return 0 # invalid test case. Hence zero ways
        return self.recurse(amount, coins, 0)

    def recurse(self, amount: int, coins: list[int], index: int)-> int:

        # base condition: (these are the valid and invalid cases we should handle)
        if amount == 0:
            return 1
        
        if index >= len(coins) or amount < 0:
            return 0 # 0 ways
    
        # logic:
        case0 = self.recurse(amount, coins, index + 1) # these are the paths when do no choose to go ahead with the current coin
        case1 = self.recurse(amount-coins[index], coins, index) # these are the paths when we move ahead with the current coin
        return case0 + case1 # returning all valid paths (i.e. when amount becomes 0) from case0 and case1

# Tablulation method 
# Time Complexity: O(m*n)

class Solution:
    def change(self, amount: int, coins: list[int]) -> int:
        if coins == None or len(coins) == 0:
            return 0

        n = len(coins)

        # create matrix
        dp = [[0] * (amount + 1)] * (n+1)
        
        # filling the first column, i.e. column of amount 0 with 1.
        # Since you don't choose any coins (similar to case0) you return amount 0. Hence 1 way counted
        for i in range(n + 1):
            dp[i][0] = 1
        
        # filling the first row from column where amount is 1 till end with 0.
        # there are 0 ways to achive any amount >= 1 with 0 coins. Hence 0 ways
        for j in range(1, amount + 1):
            dp[0][j] = 0


        # adding all values in the matrix
        for i in range(1, n+1):
            for j in range(1, amount+1):
        
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - (coins[i-1])]
        
        return dp[n][amount]
