# 518. Coin Change 2
# https://leetcode.com/problems/coin-change-2/

# Brute Force
class Solution:
    def __init__(self):
        self.res = 0
    
    def _helper(self, coins, amount, idx):
        if amount == 0:
            self.res += 1
            return
        
        if amount < 0:
            return
        
        if idx == len(coins) and amount != 0:
            return

        # Not Taken
        self._helper(coins, amount, idx+1)
        # Taken
        self._helper(coins, amount-coins[idx], idx)

    def change(self, amount, coins) -> int:
        self._helper(coins, amount, 0)

        return self.res

# obj = Solution()
# print(obj.change(4, [1,2,3]))
# print(obj.change(10, [2,5,3,6]))


# DP
# Time complexiety: O(n*m)
# Space complexiety: O(n*m)

# Cell represents: number of ways in with the amount can be created with the available coins.

class Solution:
        def change(self, amount, coins) -> int:
            dp = [[0 for i in range(amount+1)] for i in range(len(coins)+1)]
            
            for i in range(len(coins)+1):
                dp[i][0] = 1
            
            for i in range(1,len(coins)+1):
                for j in range(1,amount+1):
                    if j < coins[i-1]:
                        dp[i][j] = dp[i-1][j]
                    else:
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

            return dp[len(coins)][amount]

obj = Solution()
print(obj.change(4, [1,2,3]))