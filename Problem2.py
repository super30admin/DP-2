"""518. Coin Change 2
Time Complexity - O(nxm)
Space Complexity - O(nxm)
Make a dp 2-D matrix and initialize value of first row,first column
If j is les than coin value
    update dp with adjacent cell value
else        
    dp is addition of previous element and above element"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0]*(amount+1)]*(len(coins)+1)
        
        "column"
        for i in range(0,len(coins)+1):
            dp[i][0] = 1
        
        "Implementation"
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
        return dp[len(coins)][amount]