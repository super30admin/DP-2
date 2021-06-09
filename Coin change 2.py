# DP with memoization:
class Solution:
    def __init__(self):
        self.hashmap = {}

    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(amount, coins, 0)

    def helper(self, amount, coins, pos):
        if amount == 0: return 1
        if pos == len(coins) or amount < 0: return 0

        if (amount, pos) in self.hashmap:
            return self.hashmap[(amount, pos)]

        take = self.helper(amount - coins[pos], coins, pos)
        skip = self.helper(amount, coins, pos + 1)

        self.hashmap[(amount, pos)] = (take + skip)
        return self.hashmap[(amount, pos)]




