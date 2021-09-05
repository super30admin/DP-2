class Solution:
    def change(self, amount: int, coins) -> int:
        if coins is None or len(coins) == 0:
            return 0

        # dp = [0] * (amount + 1)
        dp = [[0] * (amount + 1) for i in range(len(coins) + 1)]  # will initialize a matrix with 0 as value
        # print(dp)
        for i in range(len(coins) + 1):  # making indices 0 of each column 1
            dp[i][0] = 1

        # print([coins[i -1] for i in range(1, len(dp))])
        # print([j for j in range(1, len(dp[0]))])
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        # print(dp[-1][-1])
        return dp[-1][-1]


obj = Solution()

print(obj.change(11, [1, 2, 5]))
