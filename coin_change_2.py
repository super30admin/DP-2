# Time Complexity: O(mn) where m is number of columns(amount + 1) and n is number of rows(coins + 1)
# Space Complexity: O(mn) where m is number of columns(amount + 1) and n is number of rows(coins + 1)
# Ran on leetcode: Yes

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [[0]*(amount+1)]*(len(coins)+1)
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        return dp[len(dp)-1][len(dp[0])-1]
        