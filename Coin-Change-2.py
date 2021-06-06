class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins)==0:
            return 0

        dp=[[0]*(amount+1) for coin in range(len(coins)+1)]#to make amount zero, don't use the coin, so 1 way
        for i in range(len(dp)):
            dp[i][0]=1

        print(dp)
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                #out of bound
                if j-coins[i-1] <0:
                    dp[i][j]=dp[i-1][j]
                #actual cell value
                else:
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]]
        print(dp)
        return dp[len(dp)-1][len(dp[0])-1]
