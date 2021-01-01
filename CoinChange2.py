'''
    Time Complexity:
        O(nm) (where n = amount and m = number of coins)
        -> There will be nm unique states that the helper will run into and
            internally, each state just does O(1) work.

    Space Complexity:
        O(nm) (where n = amount and m = number of coins)
        -> Since key of the HashMap is a tuple of (house, paint), at the most
            there could be 3n k,v pairs in the HashMap.

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        -> At each iteration, either you select the coin or ignore the coin.
        -> If your amount == 0, that means you found 1 way of making the given sum.
        -> If the amount < 0 or you have exhausted the coins list, that means you
            won't be able to make the given sum with the current set of coins.
            Return 0.
        -> Return the sum of selecting and ignoring.
        -> Memoize it to get better TC.
'''
class Solution:
    def __init__(self):
        self.coins = []
        self.dp = {}

    def change(self, amount: int, coins: List[int]) -> int:
        self.coins = coins
        self.coins.sort()
        return self.find_ways(amount, 0)

    def find_ways(self, amount_left, idx):
        if amount_left == 0:
            return 1

        if amount_left < 0 or idx >= len(self.coins) or self.coins[idx] > amount_left:
            return 0

        if (amount_left, idx) not in self.dp:
            select = self.find_ways(amount_left - self.coins[idx], idx)
            ignore = self.find_ways(amount_left, idx + 1)
            self.dp[(amount_left, idx)] = select + ignore

        return self.dp[(amount_left, idx)]
