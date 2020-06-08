class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins==None or len(coins)==0:
            return 0
        
        dp=[[0 for x in range(len(coins)+1)] for y in range(amount+1)]
        m=len(dp)
        n=len(dp[0])
        for i in range(1,n):
            dp[0][i]=0
        for i in range(1,m):
            for j in range(1,n):
                if(j<coins[i-1]):
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        result=dp[m-1][n-1]
        if result>=9999:
            return -1
        return result
    
