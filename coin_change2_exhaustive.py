"""
Time Complexity : O(2^m*n) where m is the number of coins and n is the amount
Space Complexity : O(2^m*n) where m is the number of coins and n is the amount. The dp matrix used to calculate number of ways
Did this code successfully run on Leetcode : Time Limit Exceeded
Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
1. Greedy fails so we should try Exhaustive search
2. In exhaustive search we create each and every path and find the optimum answer in all the possible paths
"""


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0

        return self.helper(coins, amount, 0)

    def helper(self, coins, amount, index):
        # base case
        if amount == 0:
            return 1
        if amount <= 0 or len(coins) == index:
            return 0

        # logic
        case0 = self.helper(coins, amount, index + 1)

        case1 = self.helper(coins, amount - coins[index], index)

        return case1 + case0
