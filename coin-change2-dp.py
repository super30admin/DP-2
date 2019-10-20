#I am getting index out of range error while running the dp solution on Github. 
#Also,I waould like to know best way to initialize 2d array in python. 

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[x for x in range(amount+1)] for y in range(len(coins)+1)]
        dp[0][0] = 1
        n = len(dp)
        m = len(dp[0])
        for i in range(1,n):
            dp[i][0] = 1
            for j in range(1,m):
                #dp[0][j] = 0
                #dp[1][j] = 1
                if(j< coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j-coins[i-1]]
        return dp[n-1][m-1]