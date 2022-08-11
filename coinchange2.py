#executed on leetcode
#time complexity - O(mn)
#space complexity - O(mn)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[1]+[0]*amount for _ in range(len(coins)+1)]
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if coins[i-1] <= j:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[len(coins)][amount]  # or dp[-1][-1]

        