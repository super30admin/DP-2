"""
Coin Change - 2

Time Complexity : O(m*n) n is number of denominations and m is the amount. 
Space Complexity : O(m*n)
    
"""

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins or len(coins) == 0:
            return 0 
        
        matrix = [[None for _ in range(amount + 1) ] for _ in range(len(coins)+1)]
        m = len(matrix)
        n = len(matrix[0])
        
        for i in range(m):
            matrix[i][0] = 1 
        
        for j in range(1, n):
            matrix[0][j] = 0 
        
        
        for a in range(1, m):
            for b in range(1, n):
                if b < coins[a-1]:
                    matrix[a][b] = matrix[a-1][b]
                else:
                    matrix[a][b] = matrix[a-1][b] + matrix[a][b - coins[a-1]]
     
        return matrix[m-1][n-1]
                    