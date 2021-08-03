class Solution:

    """
    Recursive exhastive approach
    TC - O(N)
    SC - O(N)
    """
    def approach1(self, amount, coins, index):
        if amount == 0:
            return 1
        if index >= len(coins) or amount < 0:
            return 0

        nothing = self.approach1(amount, coins, index + 1)
        pick = self.approach1(amount - coins[index], coins, index)

        return nothing + pick

    """
    DP approach
    TC - O(nxm)
    SC - O(nxm)
    """
    def approach2(self, amount, coins):
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]
        for i in range(len(coins) + 1):
            dp[i][0] = 1
        for i in range(1, len(dp)):
            for j in range(len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j]
        return dp[len(dp) - 1][len(dp[0]) - 1]

    def change(self, amount: int, coins: List[int]) -> int:
        if coins is None and not coins:
            return 0
        # return self.approach1(amount,coins,0)
        return self.approach2(amount, coins)
