# https://leetcode.com/problems/coin-change-ii/

# void based recursion
class Solution:
    count = 0
    def change(self, amount: int, coins: List[int]) -> int:
        self.helper(coins, amount, 0)
        return self.count

    def helper(self, coins, amount, i):

        if i == len(coins) or amount < 0:
            return

        if amount == 0:
            self.count += 1
            return
        
        #case0
        self.helper(coins, amount, i+1)

        #case1
        self.helper(coins, amount-coins[i], i)

# int based recursion 1
class Solution:
    count = 0
    def change(self, amount: int, coins: List[int]) -> int:
        self.helper(coins, amount, 0)
        return self.count

    def helper(self, coins, amount, i):

        if i == len(coins) or amount < 0:
            return 0

        if amount == 0:
            self.count += 1
            return 1
        
        #case0
        self.helper(coins, amount, i+1)

        #case1
        self.helper(coins, amount-coins[i], i)

# int based recursion 2
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(coins, amount, 0)

    def helper(self, coins, amount, i):

        if i == len(coins) or amount < 0:
            return 0

        if amount == 0:
            return 1
        
        #case0
        case0 = self.helper(coins, amount, i+1)

        #case1
        case1 = self.helper(coins, amount-coins[i], i)

        return case0 + case1

# DP with tabulation. Smaller problems and then populating bigger problems

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount

        dp = [[0] * (n+1) for _ in range(m+1)]
        dp[0][0] = 1

        for i in range(1, m+1):
            for j in range(0, n+1):

                # choose case not available
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]

        return dp[m][n]