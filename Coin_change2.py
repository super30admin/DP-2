class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for i in range(amount+1)] for j in range(len(coins) + 1)]
        
        for i in range(len(dp)):
            dp[i][0] = 1
            
        coins.sort()
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    # print(i,j)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        # print(dp[1])        
        return dp[-1][-1]