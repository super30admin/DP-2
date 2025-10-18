# Time is O(M*N)
# Space is also same due to self.memo map and the recursion depth stack

# The intuition is simple, we chose and not chose, if we chose then subtract the amount with the coins and increment the result if the amount becomes 0. 

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        self.memo = {}
        return self.helper(coins, amount, 0)

    def helper(self, coins: List[int], amount: int, idx: int) -> None:
        # base case
        if idx == len(coins) or amount < 0:
            return 0

        if amount == 0:
            return 1

        if (amount, idx) in self.memo:
           return self.memo[(amount, idx)]

        # logic
        # 0
        case1 = self.helper(coins, amount, idx + 1)

        # 1
        case2 = self.helper(coins, amount - coins[idx], idx)

        self.memo[(amount, idx)] = case1 + case2

        return self.memo[(amount, idx)]