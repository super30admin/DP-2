#Leetcode Problem: 931
#Similar to paint houses.

class Solution:
    def minFallingPathSum(self, matrix):
        newMatrix=matrix
        
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
                if j==0:
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j+1])
                    
                elif j==len(matrix[0])-1:
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j-1])
                else:
                    matrix[i][j]+=min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1])
                    
        return min(matrix[-1])

#TC: O(m*n)
#SC: O(1) as we are using same matrix.
