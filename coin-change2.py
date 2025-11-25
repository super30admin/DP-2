Initialize a 2x2 array with rows = length of coins+1 and cols amount +1. Make the first row of 
the array as 0 and the first column as 1. FOr each denomination of coin and each amount from 0 to
amount,, check if the denomination is grater than the amount, if it is, the value of dp for that 
row and colum will be the same as the previous row else, it will be the summation of the previous row 
and the current row and colum-denomination block away.

Time complexity O(m*n), m is amount, n is numver of denomination of coins
Space complexity O(m*n) m is amount, n is numver of denomination of coins



class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        rows = len(coins)+1
        cols = amount+1

        dp = [[None for i in range(cols)]for i in range(rows)]
        for i in range(cols):
            dp[0][i]=0
        for i in range(rows):
            dp[i][0]=1
        for i,c in enumerate(coins):
            for j in range(1,cols):
                if c>j:
                    dp[i+1][j]=dp[i][j]
                else:
                    dp[i+1][j]=dp[i][j]+dp[i+1][j-c]
        return dp[rows-1][cols-1]
        



# class Solution(object):
#     def change(self, amount, coins):
#         """
#         :type amount: int
#         :type coins: List[int]
#         :rtype: int
#         """
#         rows = len(coins)+1
#         cols = amount+1

#         dp = [0 for i in range(cols)]

#         dp[0]=1
#         for i,c in enumerate(coins):
#             for j in range(1,cols):
#                 if c<=j:
#                     dp[j]=dp[j]+dp[j-c]
#         return dp[cols-1]
        