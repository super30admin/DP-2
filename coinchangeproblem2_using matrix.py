#Space Complexity = O(nm) used matrix two decision parameter coins denomination and amount  and 
#Time Complexity = O(nm) m-> number of coins denomination n-> steps required to get amount
#did your code run on leetcode = yes
import numpy as np
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == [] or  len(coins) == 0: return 0
        
        rows = len(coins) + 1
        cols = amount + 1
        size = rows * cols
        
        dp = np.array([0]*size).reshape(rows,cols)
        #1 possibility for all combination of coins when the amount should sum up to 0
        for i in range(0,len(dp)):
            dp[i][0] = 1
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                #not choose coin
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                    
                #choose coin
        
        return dp[len(coins)][amount]
        
