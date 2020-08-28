class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        rows = len(coins) + 1
        columns = amount + 1
        matrix = [[ 0 for _ in range(columns)] for _ in range(rows)]
        
        for _ in range(rows):
            matrix[_][0] = 1
            
        for r in range(1, rows):
            for c in range(1, columns):
                if(coins[r - 1] > c):
                    matrix[r][c] = matrix[r - 1][c]
                else:
                    matrix[r][c] =  matrix[r - 1][c] + matrix[r][c - coins[r - 1]]
        
        return (matrix[len(coins)][amount])
