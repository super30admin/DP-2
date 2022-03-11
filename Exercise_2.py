    # 518. Coin Change 2

    # Time Complexity : O(m*n)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [[0] * (amount+1) for _ in range(len(coins)+1)]

        for i in range(len(dp)):
            dp[i][0] = 1
        # print(dp)
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        # print(dp)
        return dp[-1][-1]