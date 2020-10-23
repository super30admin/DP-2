"""
Time Complexity : O(m*n) whene m is numbr of coins and n is the amount
Space Complexity : O(M*n) as it is a 2D matrix
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We first tried the recursive approach which gave time limit exceeded. Then we shifted to Dynamic Programming
solution. Here we analysed that there are 2 parameters on which are soltion depends, them being number
of coins and amount. So we made a 2D matrix with m+1 rows and n+1 columns. We made an extra row for 0
as it would help us in calculation. For 0, we fill in all zeroes except for the [0][0] position.
This is because, if i have 0 coins, and i want to make 0, then I have 1 way, ie choosing it. So its is 1.
But if i have 0 coins and i want to make any other amount, there is no way to do it. Hence all others are 0.
for rest of the matrix, for all other coins, we have 2 options, either to take it or to not take it.
If i do not want to take it, then answer is directly above. If i want to take it, then answer lies in the
same row, position- coin value. So we add both the ways to find our answer. At the end, we return last row 
last column value
"""


class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        m = len(dp)
        n = len(dp[0])
        for i in range(m):
            dp[i][0] = 1
        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[-1][-1]
#     def change(self, amount, coins):
#         """
#         :type amount: int
#         :type coins: List[int]
#         :rtype: int
#         """
#         if coins== None:
#             return 0
#         return self.helper(coins,amount,0)

#     def helper(self,coins,amount,idx):
#         if amount==0:
#             return 1
#         if idx>=len(coins) or amount<0:
#             return 0
#         case1=self.helper(coins,amount,idx+1)
#         case2=self.helper(coins,amount-coins[idx],idx)
#         return case1 + case2
