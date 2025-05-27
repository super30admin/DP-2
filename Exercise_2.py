# Time Complexity  : O(n * amount) where n = len(coins)
# Space Complexity : O(n * amount) for the DP table
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        #Tabulation
        n = len(coins)
        # dp table of size (n+1) x (amount+1)
        dp = [[0] * (amount + 1) for _ in range(n + 1)]
        
        # one way to make amount 0 with any number of coins
        for i in range(n + 1):
            dp[i][0] = 1
        
        # fill table
        for i in range(1, n + 1):
            coin = coins[i - 1]
            for x in range(1, amount + 1):
                # 1) skip this coin
                dp[i][x] = dp[i - 1][x]
                # 2) take this coin (if it fits)
                if x >= coin:
                    dp[i][x] += dp[i][x - coin]
        
        return dp[n][amount]

#---------------------------------------------------------------------

        #Memoization
        # n = len(coins)

        # if n == 1:
        #     if amount % coins[0] == 0:
        #         return 1
        #     else:
        #         return 0

        # memo = [[-1] * (amount + 1) for _ in range(n)]

        # def helper(i, rem):
            
        #     if rem == 0:
        #         return 1

        #     if i == n or rem <= 0:
        #         return 0

        #     if memo[i][rem] != -1:
        #         return memo[i][rem]

        #     take = helper(i, rem - coins[i])
        #     skip = helper(i + 1, rem)

        #     memo[i][rem] = take + skip
        #     return memo[i][rem]

        # return helper(0, amount)

#---------------------------------------------------------------------

        #Recursive
        # n = len(coins)

        # if n == 1:
        #     if amount % coins[0] == 0:
        #         return 1
        #     else:
        #         return 0

        # def helper(i, rem):
            
        #     if rem == 0:
        #         return 1

        #     if i == n or rem <= 0:
        #         return 0

        #     take = helper(i, rem - coins[i])
        #     skip = helper(i + 1, rem)

        #     return take + skip

        # return helper(0, amount)

#---------------------------------------------------------------------

if __name__ == "__main__":
    sol = Solution()
    # Example 1
    print(sol.change(5, [1, 2, 5]))   # expected 4
    # Example 2
    print(sol.change(3, [2]))         # expected 0
    # Example 3
    print(sol.change(10, [10]))       # expected 1
    # Additional tests
    print(sol.change(0, [1, 2, 3]))   # expected 1 (one way to make 0: no coins)
    print(sol.change(7, [2, 3, 6, 7]))# expected 2 (7=7, 7=2+2+3)