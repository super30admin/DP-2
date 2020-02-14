'''
Time Complexity :O(S*n) A is the amount and n is the number of coins
Space Complexity: O(1)
Did this code successfully run on Leetcode : No (Max Recursive depth on large denomination and few edge cases to fix)
Explanation: Create a function and traverse recursively every time we decrease the amount by a denomination and find
all subproblems, count the number of correct subproblems on the way
'''

class Solution:

    def change(self, amount: int, coins: List[int]) -> int:
        return self.Change(coins, amount, 0)

    def Change(self, coins: List[int], amount: int, count: int) -> int:

        if amount < 0 or count >= len(coins) - 1:
            return 0

        if amount == 0:
            return 1

        case2 = self.Change(coins, amount, count)
        case1 = self.Change(coins, amount - coins[i], count + 1)

        return case1 + case2