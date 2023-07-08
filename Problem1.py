# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m=amount
        n=len(coins)
        matrix=[[0 for columns in range(m+1)] for row in range(n+1)]
        matrix[0][0]=1

        for j in range(1,m+1):
            matrix[0][j]=0

        for i in range(1,n+1):
            for j in range(0,m+1):
                if j<coins[i-1]:
                    matrix[i][j]=matrix[i-1][j]
                else:
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-coins[i-1]]
        
        return matrix[n][m]