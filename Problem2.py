# Time Complexity : O(mn) where n is the number of rows of the coins and m is the number of columns of amount in the matrix  
# Space Complexity : O(mn) we are creating a matrix of size mn in storing in a variable 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Yes it is difficult ot create a 2D array in python


# Your code here along with comments explaining your approach : - We create a matrix table of rows and columns and calculate sum of number of ways based on previous way that we have used 

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount + 1
        dp = []
        for i in range(0,m+1):
            cols = []
            for j in range(0,n):
                cols.append(0)
            dp.append(cols)
        
        
        for i in range(0,m+1):
            dp[i][0] = 1
        
        for i in range(1,m+1):
            for j in range(1,n):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+ dp[i][j-coins[i-1]] 
        return dp[m][n-1]