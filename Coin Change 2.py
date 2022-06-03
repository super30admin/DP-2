""""// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def change(self, amount, coins):
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = 1
        for j in range(1, n + 1):
            dp[0][j] = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[m][n]



#Exhaustive approach-
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         if not coins or len(coins)==0:
#             return 0
#         return self.helper(amount, coins, 0)
#     def helper(self, amount, coins, index):
#         #base
#         if amount==0:
#             return 1
#         if amount<0 or index==len(coins):
#             return 0
#         #logic
#         case1=self.helper(amount-coins[index], coins, index)
#         case2=self.helper(amount, coins, index+1)
#         return case1+case2
