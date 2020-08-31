class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
       
        if amount == 0:
            return 1
        
        n = len(coins)
        dp = [[1 for _ in range(amount +1)] for _ in range(n+1)]
        
        for j in range(amount+1):
            dp[0][j] = 0
                
        for i in range(1,n+1):
            for j in range(1,amount+1):  
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+ dp[i][j-coins[i-1]]
                
        return dp[n][amount]
    
#Time Complexity = O(N * n) where N is length of coins array and n is amount
#Space Complexity = O(N *n)
    