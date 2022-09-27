# Time Complexity : O(n) where n is the number of rows of the houses here column is constant which is 3 so n is the time complexity
# Space Complexity : O(n) we are creating a matrix of size n in storing in a variable 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Yes it is difficult ot create a 2D array in python


# Your code here along with comments explaining your approach : - We create a matrix where we start with last row and alternatively add in previous to last row and store the min value until we go till top row and then pass the min value from top row 


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        dp = []
        dp =costs 
        
        for i in range(n-2,-1,-1):
            for j in range(0,3):
                if j ==0:
                    dp[i][j] = min(dp[i][j]+dp[i+1][j+1],dp[i][j]+dp[i+1][j+2])
                elif j ==1:
                    dp[i][j] = min(dp[i][j]+dp[i+1][j-1],dp[i][j]+dp[i+1][j+1])
                elif j ==2:
                    dp[i][j] = min(dp[i][j]+dp[i+1][j-2],dp[i][j]+dp[i+1][j-1])
        print(dp)
        return min(dp[0][0],dp[0][1], dp[0][2])
            