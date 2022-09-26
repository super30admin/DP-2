'''
Time Complexity: O(N*range(amount))
Space Complexity: O(N*range(amount))
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows = len(coins)+1
        cols = amount +1
        matrix = [1]*rows
        for i in range(rows):
            matrix[i] = [1]*cols
        for i in range(1, cols):
            matrix[0][i] = 0
        for i in range(1, rows):
            for j in range(1, cols):
                if(j<coins[i-1]):
                    matrix[i][j] = matrix[i-1][j]
                else:
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i-1]]
        return matrix[rows-1][cols-1]
        