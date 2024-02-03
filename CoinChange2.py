# Time complexity : O(mn)  m is the amount and n is the number of coins
# Space complexity: O(m) m is the length of the array

class Solution:
    def change(self, amount: int, coins: list[int]) -> int:
        # return self.helper(amount, coins, 0)
        # Initializing dp array to store number of way to make particular amount
        dp = [0] * (amount + 1)
        dp[0] = 1

        # Here I am updating an array as I considering the more number of coins.
        # This array tells me the number of ways to make amount with respect of coins

        for i in range(len(coins)):
            for j in range(amount + 1):
                if j >= coins[i]:
                    dp[j] += dp[j - coins[i]]
        return dp[-1]

    # def helper(self, amount, coins, idx):
    #     if idx == len(coins) or amount < 0 :
    #         return 0
    #     if amount == 0:
    #         return 1

    #     # Choose
    #     re1 = self.helper(amount - coins[idx], coins, idx)

    #     # Not Choose
    #     re2 = self.helper(amount, coins, idx + 1)

    #     return re1 + re2
