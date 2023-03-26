# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : having visual map difficult to track


# Your code here along with comments explaining your approach
"""
create 2d array with coins as rows and 0 to amount + 1 as columns. create base case. there is always 1 way of getting 0 coins out of any number of coins
1st row will have 0 ways to reach amount except 0 amount. go through each element and add above element and amount - coin element
"""


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = []
        for i in range(len(coins)):
            dp.append([0] * (amount + 1))
            dp[i][0] = 1


        for i in range(len(dp)):
            for j in range(1,amount + 1):
                if i == 0:
                    dp[i][j] = 0
                    if j - coins[i] >= 0:
                        dp[i][j] += dp[i][j-coins[i]]
                else:
                    dp[i][j] = dp[i-1][j]
                    if j - coins[i] >= 0:
                        dp[i][j] += dp[i][j-coins[i]]

        return dp[len(coins)-1][amount]
