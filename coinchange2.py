"""
#coin change 2

Time Complexity : O(m*n) m -> len(coins) and n -> amount
Sc -0(m*n)

approach -> use dynamic programming. Use a dp matrix to store the number of possible ways to make an amount with the coins available 
"""

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        #null case
        if (coins ==None):
            return 0
            # 2 constarints create a dp matrix
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(len(dp)):
            dp[i][0] = 1
        
        for i in range (1,len(dp)):
            for j in range (1,len(dp[0])):
                #denomination of coin is less than j
                if j<coins[i-1]:
                    #zero case
                    dp[i][j]=dp[i-1][j]
                else:
                    #zero case and one case
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[len(dp)-1][len(dp[0])-1]