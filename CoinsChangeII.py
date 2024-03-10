class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        #Initialize a 2d array no.of columns is all possible amounts
        dp = [[0]*(amount+1) for _ in range(n+1)]
        for i in range(len(coins)+1):
            dp[i][0]=1
        for i in range(1,n+1):
            for j in range(1,amount+1):
                #If the amount to be made is less than that coin in the row
                if coins[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]

    
        return dp[-1][-1]