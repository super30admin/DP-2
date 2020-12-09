'''
Time complexity :O(N)
Space complexity :O(N)
'''

from itertools import product

class Solution:
    def change(self, amount: int, coins) -> int:
        N = len(coins)
        if N == 0: 
            return int(N == amount)
        
        dp_sum = [[0] * N for _ in range(amount + 1)]
        for i in range(N): 
            dp_sum[0][i] = 1
        
        for i,j in product(range(amount), range(N)):
            dp_sum[i+1][j] = dp_sum[i+1][j-1]
            if i+1 - coins[j] >= 0:
                dp_sum[i+1][j] += dp_sum[i+1-coins[j]][j]           
                    
        return dp_sum[-1][-1]

print(Solution().change(5,[1,2,5]))

