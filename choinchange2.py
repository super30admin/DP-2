import numpy as np
class Solution:
    def change(self, amount, coins):
       
        coins.sort()
        n = len(coins) + 1
        m = amount + 1
        
        dp = np.arange(n*m).reshape(n,m)
        
        for i in range(n):
            dp[i][0] = 1
            
        for i in range(1,m):
            dp[0][i] = 0
            
            
        for i in range (1,n):
            for j in range(1,m):
                
                if (j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                    
                else:
                    dp[i][j] =  dp[i-1][j] + dp[i][j - coins[i-1]]
                    
                    
        
        return dp[n-1][m-1]



#TC : O(nm)
#SC : O(nm)
        
