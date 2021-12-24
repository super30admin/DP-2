# Time: O(n*m)
# Space: O(n*m)
class Solution(object):
    def change(self, amount, coins):
        mat = [[0 for x in range(amount+1)] for y in range(len(coins)+1)]
        #print(mat)
        for i in range(1, amount+1):
            mat[0][i] = 0
        for i in range(1, len(coins)+1):
            mat[i][0] = 1
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    mat[i][j] = mat[i-1][j]
                else:
                    mat[i][j] = mat[i-1][j]+mat[i][j - coins[i-1]]
        #print(len(coins)+1, amount)
        return mat[len(coins)][amount]
        
