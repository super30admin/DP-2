# Coins Change 2

# Time Complexity : O(S∗n) where S is the amount and n is the coins denominations
# Space Complexity : O(S) as extra space for 2D array(table) is used.
# Did this code successfully run on Leetcode : Yes, Runtime: 540 ms Memory Usage: 30 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
 The Brute force approach of receursion and Greedy algorithm failed so used Dynamic Programming approach which uses 2 dimensional array to solve the problem
 with amount values being rows and coins denominations as columns. Traversing across
 the array and finding the ways which amounts up to i i.e 0 to 11.

"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [[0 for i in range(amount+1)] for x in range(n+1)] # Initializing 2D Array
        for i in range(n+1):
            dp[i][0] = 1 # Copying values of 1 for row 1 in tabulation
        for i in range(1, n+1):
            for j in range(1, amount+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[n][amount]