# Time Complexity : O(m*n)
# Space Complexity : O(M)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def change(self, amount: int, coins) -> int:
        if len(coins)==0:
            return 0
        
        dp = [[0 for j in range(amount+1)] for i in range(len(coins)+1)]
        dp[0][0] = 1
        
        for i in range(len(coins)+1):
            dp[i][0] = 1
    
        for i in range(1,len(dp)):
            for j in range(1, len(dp[0])):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[-1][-1]
            



obj = Solution()
coins = [1,2,5]
amount = 5
print(obj.change(amount,coins))