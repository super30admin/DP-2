# Time complexity : O(m*n)
# Space complexity : O(m*n)

# The code ran on Leetcode
 # I am maintaining a 2d DP array to maintain number of was to get a partciular sum. The amount is on x axis and the coin is on y axis. At every index, we can either select the coin or don't select it, which is represeneted in this line : dp[i][j] = dp[i-1][j] + dp[i][j - coin]
 
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        c = len(coins)
        dp = [[0]*(amount + 1)]*(c + 1)
        if amount == 0: return 1
        for i in range(1, c+1):
            coin = coins[i - 1]
            for j in range(1, amount + 1):
                dp[i][0] = 1
                
                if j < coin:
                    dp[i][j] = dp[i-1][j]

                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coin]

        return dp[-1][-1]