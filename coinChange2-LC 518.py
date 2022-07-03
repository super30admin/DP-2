# Time Complexity = O(m * n), m = number of rows (index of coins array), n = amount 
# Space Complexity = O(m * n), Using 2D matrix to store answers/computations.

class Solution:
    def change(self, amount: int, coins: list[int]) -> int:
        if len(coins) == 0 or coins is None:
            return 0
        
        m = len(coins)      # for rows
        n = amount          # for cols
        dp = [[0] * (n + 1)] * (m + 1)      # +1 since Tabulating for coin value 0 and amount 0 too
        
        for i in range(m + 1):          # i denotes rows
            dp[i][0] = 1                # all coin values can make amount = 0 in exactly 1 way, i.e. by choosing 0 value coin from the array
            
        for j in range(1, n + 1):       # j denotes cols
            dp[0][j] = 0                # For different amount values, no combinations can be formed with a 0 value coin

        # Iterating for rows and cols    
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # If amount < value of coin at that index, copy from the above row
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                # If amount >= the value of coin, we add the result of 'not choosing that index element' and 'choosing that index element', since total number of possible combinations is required
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        # Last element of the matrix gives the answer            
        return dp[m][n]
        
        
        