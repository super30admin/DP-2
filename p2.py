# Time Complexity : O(n*amount)
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


#  Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        if len(coins) == 0 or amount == 0:
            return 1

        f = [0 for i in range(amount + 1)]
        f[0] = 1
        for i in range(amount + 1):
            if i % coins[0] == 0:
                f[i] = 1

        for j in range(1, len(coins)):
            for i in range(coins[j], amount + 1):
                f[i] += f[i - coins[j]]

        return f[-1]

