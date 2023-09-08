class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None or len(coins) == 0:
            return -1
        
        row = len(coins) + 1
        col = amount + 1
        dp = [[0 for i in range(col)] for j in range(row)]
        
        for i in range(row):
            dp[i][0] = 1
            
        for i in range(1,row):
            for j in range(1,col):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        
        return dp[len(coins)][amount]

# TC: O(n)(m)
# SC: O(n)(m)