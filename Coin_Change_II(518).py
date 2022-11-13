# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        res = [[0 for _ in range(amount+1)] for _ in range(n+1)]
        #Padding the first column with 1s as it will cover the case when we decide not to take
        # a coin when the amount is still 0
        for i in range(n+1):
            res[i][0] = 1

        # Similar to coin change-1 if the selected coin is less than amount we just copy the case
        # from the column above as the curr_coin wont contribute
        # Here we take the addition of the 2 cases(since we need to give out all combos) where
        # the amount can be formed without the curr_coin (just the column above) and
        # Once the curr_coin is selected, what number of coins are required to form the remaining amount
        for coin_idx in range(1,n+1):
            curr_coin = coins[coin_idx - 1]
            for amount_idx in range(1,amount+1):
                if curr_coin > amount_idx:
                    res[coin_idx][amount_idx] = res[coin_idx-1][amount_idx]
                else:
                    res[coin_idx][amount_idx] = res[coin_idx][amount_idx - curr_coin] + res[coin_idx-1][amount_idx]

        return res[n][amount]