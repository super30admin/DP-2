# // Time Complexity : O(N*i)
# // Space Complexity : O(N*i)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        colorCount = len(costs[0])
        houseCount = len(costs)

        dp = [[-1 for _ in range(colorCount)] for _ in range(houseCount)]

        def helper(n, i):
            if n < 0:
                return 0
            if dp[n][i] != -1:
                return dp[n][i]
            
            withRed, withGreen, withBlue = sys.maxsize, sys.maxsize, sys.maxsize

            if i == 0:
                withRed = costs[n][i] + min(helper(n-1, 1), helper(n-1, 2))
            elif i == 1:
                withGreen = costs[n][i] + min(helper(n-1, 0), helper(n-1, 2))
            elif i == 2:
                withBlue = costs[n][i] + min(helper(n-1, 0), helper(n-1, 1))
            
            dp[n][i] = min(withRed, withBlue, withGreen)
            return dp[n][i]
        
        return min(
            helper(houseCount-1, 0),  #Red
            helper(houseCount-1, 1),  #Green
            helper(houseCount-1, 2)   #Blue 
        )
