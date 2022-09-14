class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if(amount==0):
            return 1
        m = len(coins)
        n = amount
        
        dp = [[0 for j in range(n+1)]for i in range(m+1)]
        
        dp[0][0] = 1
        
        for i in range(1,n+1):
            dp[0][i]=0
            
        for i in range(1,m+1):
            for j in range(n+1):
                if(j<coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]
        
        
        return dp[m][n]
              