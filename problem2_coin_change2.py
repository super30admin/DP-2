#https://leetcode.com/problems/coin-change-ii/solutions/
# Time Complexity : O(m * n) where m = size of coins array + 1 and n = amount + 1
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        rows = len(coins)+1
        cols = amount+1
        dp = [[0 for i in range(cols)] for j in range(rows)]
        
        for i in range(rows):
            for j in range(cols):
                if j == 0 and i!=0:
                    dp[i][j] = 1
                elif i == 0 and j!=0:
                    dp[i][j] = 0
                elif i == 0 and j == 0:
                    dp[i][j] = 1
                else:
                    if coins[i-1] > j:
                        dp[i][j] = dp[i-1][j]
                    else:
                        dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        return dp[rows-1][cols-1]