
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        m=len(coins)
        n=amount
        #dp=[m+1][n+1]
        dp=[[0] * (n+1) for _ in range(m+1)]
        dp[0][0]=1
        for i in range (1,len(dp)):
            for j in range(0,len(dp[i])):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=(dp[i-1][j]+dp[i][j-(coins[i-1])])
        
        return dp[m][n]