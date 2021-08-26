# Did this code successfully run on Leetcode : NO, TLE for some

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        def helper(amount, coins, track, result):
            if amount == 0:
                result.add(tuple(sorted(track)))
            if amount < 0:
                return
            for c in coins:
                helper(amount-c, coins, track+[c], result)
            return len(result)

        return helper(amount, coins, [], set())