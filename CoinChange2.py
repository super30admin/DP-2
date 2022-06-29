# Time Complexity : O(mn) where m is the amount and n is the coins
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if amount == 0:
            return 1

        memo = [0] * (amount + 1)

        for i in range(1, len(coins) + 1):

            temp = [0] * (amount + 1)

            for j in range(1, amount + 1):
                if coins[i - 1] > j:
                    temp[j] = memo[j]
                elif coins[i - 1] == j:
                    temp[j] = 1 + memo[j]
                else:
                    temp[j] = temp[j - coins[i - 1]] + memo[j]
            memo = temp
        return memo[amount]
