# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach


class Solution:
    def change(self, amount, coins):
        rows = len(coins) + 1
        columns = amount + 1
        dp = []
        for i in range(rows):
            dp.append([0] * columns)
        dp[0][0] = 1
        for i in range(1, rows):
            for j in range(columns):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[-1][-1]


check = Solution()
print(check.change(5, [1, 2, 5]))


# class Solution:
#     def helper(self, amount, coins, index):
#         if amount == 0:
#             return 1
#         elif amount < 0 or index >= len(coins):
#             return 0
#         case1 = self.helper(amount, coins, index + 1)
#         case2 = self.helper(amount - coins[index], coins, index)
#         return case1 + case2

#     def change(self, amount: int, coins: list[int]) -> int:
#         return self.helper(amount, coins, 0)

# check = Solution()
# print(check.change(5, [1, 2, 5]))

