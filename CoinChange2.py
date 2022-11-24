"""
    Problem Statement: Coin Change 2: Return the number of combinations that make up the amount.

    Time complexity: O(m * n)

    Space complexity: O(m * n)

    Accepted on LeetCode? Yes! 

    LeetCode Link: https://leetcode.com/problems/coin-change-2/
"""

from typing import List

class Solution:

    def helper(self, coins: List[int], amount: int, index: int) -> int:
        if amount == 0:
            return 1

        if amount < 0 or index == len(coins):
            return 0
        
        case1 = self.helper(coins, amount, index + 1)
        case2 = self.helper(coins, amount - coins[index], index)

        return case1 + case2

    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [[0 for j in range(amount + 1)] for i in range(n + 1)]
        
        for i in range(n + 1):
            dp[i][0] = 1

        for i in range(1, n + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[n][amount]

if __name__ == "__main__":
    sol = Solution()
    coins, amount = [1, 101, 102, 103], 100
    ret = sol.change(amount, coins)
    
    # assert ret == 1