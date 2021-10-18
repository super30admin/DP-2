#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
#Problem sucessfully accepted in leetcode: yes
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp=[[0 for j in range(amount+1)] for i in range(n+1)]
        
#Initialize first column
        for i in range(n+1):
            dp[i][0] = 1
        
        for i in range(1, n+1):
            for j in range(1, amount+1):
#If current column is less than denomination, it cannot contribute to sum
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
#Add sum of taking and not taking current  coin
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
                    
        return dp[n][amount]