from typing import List

class Solution:
    def coinChange(self, nums: List[int], amount: int) -> int:
        dp = [[0 for _ in range(amount+1)] for _ in range(len(nums)+1)]
        for i in range(len(nums)+1):
            for j in range(amount+1):
                if j == 0:
                    dp[i][j] = 0
                elif i == 0:
                    dp[i][j] = amount + 1
                elif j - nums[i-1] >= 0 :
                    dp[i][j] = min(dp[i][j-nums[i-1]] + 1, dp[i-1][j])
                else:
                    dp[i][j] = dp[i-1][j]
        
        if dp[len(nums)][amount] == amount + 1:
            return -1
        else:
            return dp[len(nums)][amount]

        