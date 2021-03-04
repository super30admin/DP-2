import numpy as np

class Solution:

    def coinChange(self,coins,amount):
        coins.sort()
        #print(coins)
        n = len(coins) + 1
        m = amount + 1

        dp = np.arange(n*m).reshape(n,m)

        for i in range(n):
            dp[i][0] = 0

        for i in range(1,m):
            dp[0][i] = 99999


        for i in range(1,n):
            for j in range(1,m):
                if ( j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                 
                else:                       
                    dp[i][j] = min ( dp[i-1][j], ( 1 + dp[i][j - coins[i-1]] )  ) 
                    #print(dp[i-1][j], ( 1 + dp[i][j - coins[i-1]]))

        #print(dp)

        return  -1  if (dp[n-1][m-1] == 99999)  else dp[n-1][m-1]


#TC : O(n^2)
#SC : O(n X m) == O(nm)
