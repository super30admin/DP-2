# Created by Aashish Adhikari at 1:28 PM 1/6/2021

'''
Time Complexity:
~ O(m * n) where m = amount and n = no of coins (ignoring the addition of one extra row and one extra column)

Space Complexity:
O(m * n)

'''

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """




        r = [0 for idx in range(amount+1)]
        dp = [r for idx in range(0, len(coins)+1)]


        # fill first row
        # for idx in range(0,len(r)):
        #     dp[0][idx]= 0

        # fill first column
        for idx in range(0, len(dp)):
            dp[idx][0] = 1



        for idx in range(1, len(dp)):
            for idxx in range(1, len(r)):

                if idxx < coins[idx-1]:

                    dp[idx][idxx] = dp[idx-1][idxx]

                else:
                    dp[idx][idxx] = dp[idx-1][idxx] + dp[idx][idxx-coins[idx-1]]

        return dp[-1][-1]