class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        matrix = [[0]*(amount+1) for _ in range(len(coins)+1)]
        #matrix[0][0] = 1
        for m in range(len(coins)+1):
            matrix[m][0] = 1
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    matrix[i][j] = matrix[i-1][j]
                else:
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j - coins[i-1]]
        
        return(matrix[len(coins)][amount])
    
#Time complexity is O(m*n) where m is length of coins array and n is the amount
#Space complexity isO(m*n) where m is length of coins array and n is the amount
# The approach used here is dp matrix approach 