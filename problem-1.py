"""
Approach

1. To find the minimum amount to color all 3 houses, we can start with finding the minimum amount needed to paint the first house either red, blue or green
2. we can arrive at optimal solution by solving the sub-problems
3. we create a Dp matrix with row header as house number and column header choosing red, blue or green for that perticular house
4. at each step we either choose to color the house or not to choose to color the house.
5. the optimal solution will be the minimum of the las row of our dp matrix

"""


# Time Complexity : O(n) where n is the number of houses
# Space Complexity : O(n) where n is the number of houses
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs==None or len(costs)==0:
            return 0
        
        dp = costs
        for i in range(1,len(costs),1):
            dp[i][0]+= min(dp[i-1][1],dp[i-1][2]) 
            dp[i][1]+= min(dp[i-1][0],dp[i-1][2]) 
            dp[i][2]+= min(dp[i-1][0],dp[i-1][1])
        
        return min(dp[len(costs)-1])