'''
Approach: Recursive
TC: O(2^n); n = number of coins
SC: O(1), O(n) for recursive stack
'''
'''
class Solution:


    def helper(self, n, dp_amount):

        if dp_amount==0:
            return 1

        if n<0 or dp_amount<0:
            return 0

        res = self.helper(n-1, dp_amount) + self.helper(n, dp_amount-self.coins[i])

        return res


    def change(self, amount: int, coins: List[int]) -> int:

        self.amount = amount
        self.coins = coins

        res = self.helper(len(self.coins)-1, self.amount)

        return res 
'''
'''
Approach: DP
TC: O(n*amount) to construct DP table
SC: O(amount) to store DP array
'''
'''
class Solution:


    def change(self, amount: int, coins: List[int]) -> int:

        dp = [0] * (amount+1)
        dp[0] = 1

        for coin in coins:
            for i in range(coin, amount+1):
                dp[i] = dp[i] + dp[i-coin]
                #print(dp)
        return dp[amount]
'''


class Solution:

    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n + 1)]] * (m + 1)
        # print(dp)
        dp[0][0] = 1

        for i in range(1, len(dp)):
            for j in range(len(dp[0])):
                if (j < coins[i - 1]):
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[m][n]


