class Solution:

    #bruteforce
    def change_1(self, amount: int, coins: List[int]) -> int:

        if not coins:
            return 0
        else:
            return self.helper(coins, amount, 0)

    def helper(self, coins, amount, index):

        if amount == 0:
            return 1

        if (amount < 0) or (index == len(coins)):
            return 0

        case1 = self.helper(coins, amount - coins[index], index)
        case2 = self.helper(coins, amount, index + 1)

        return case1 + case2

    def change(self, amount: int, coins: List[int]) -> int:

        dp = [[0] * (amount + 1)] * (len(coins) + 1)

        for i in range(len(coins) + 1):
            dp[i][0] = 1
        # print (dp)

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[-1][-1]