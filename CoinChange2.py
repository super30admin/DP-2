## Problem2 (https://leetcode.com/problems/coin-change-2/)

# Time Complexity : O(n*m)
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def change(self, amount, coins):
        if not coins:
            return 0
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[-1][-1]
