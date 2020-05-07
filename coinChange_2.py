# Time Complexity :O(M*N) M = amount, N = no: of coins
# Space Complexity : O(M)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class Solution:
    def change(self, amount: int, coins: [int]):
        dp = [[0] * (amount + 1) for i in range(len(coins) + 1)]
        for i in range(len(coins) + 1):
            for j in range(amount + 1):
                if j == 0:
                    dp[i][j] = 1
                elif i == 0:
                    dp[i][j] = 0
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if coins[i - 1] <= j:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
                else:
                    dp[i][j] = dp[i - 1][j]
        return dp[len(dp)-1][len(dp[0])-1]


r = Solution()
amount, coins = 5, [1, 2, 5]
print(r.change(amount, coins))
