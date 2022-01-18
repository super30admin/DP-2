 # // Time Complexity : O(M*N)
 # // Space Complexity : O(M*N)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if(len(coins)==0): return 0
        dp = [[0]*(amount+1)]*((len(coins)+1))
        for i in range(0,len(dp)):
            dp[i][0]=1 #chances of getting amounts by not using the denominations
        for i in range(1,len(dp)):
            for j in range(1, len(dp[0])):
                if (j<coins[i-1]):
                    dp[i][j] = dp[i-1][j] #till the amount is less than the denomination
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                    
        return dp[len(dp)-1][len(dp[0])-1]
    
              
        