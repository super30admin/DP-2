"""
Approch: return 1 in the base case when amount == 0 denoting 1 valid way. Try all ways to get all possible ways.
Memoize it.
"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [[-1 for i in range(amount + 1)] for j in range(n)]
        def recurse(index, amount):
            if amount == 0:
                return 1

            if index == 0:
                if amount % coins[0] == 0:
                    return 1
                return 0
            if dp[index][amount] != -1:
                return dp[index][amount]
            ret = 0
            if amount >= coins[index]:
                ret += recurse(index, amount - coins[index])
            ret += recurse(index - 1, amount)
            dp[index][amount] = ret
            return ret
        return recurse(n - 1, amount)