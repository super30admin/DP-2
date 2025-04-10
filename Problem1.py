# Problem 1 : Paint House
# Time Complexity :
'''
2-d array - O(n) where n is the is the length of costs array ie number of house
# variables - O(n) where n is the is the length of costs array ie number of house
'''
# Space Complexity :
'''
2-d array - O(n) where n is the is the length of costs array ie number of house
3 variables - O(1)
'''
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
# 2-d array

from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # get the length of the costs lists
        n = len(costs)
        # define the dp matrix with 3 columns and n rows(number of house)
        dp = [[0] * 3 for _ in range(n)]
        # set the values for last row for the three colors same as values for last houses
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]
        
        # loop from n-2th house to 1st house
        for i in range(n-2, -1, -1):
            # get the values for every color for the house
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        # return min values of all three color
        return min(dp[0][0], min(dp[0][1], dp[0][2]))

# Example usage:
# solution = Solution()
# print(solution.minCost([[17,2,17], [16,16,5], [14,3,19]]))

# Using 3 variables 
from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # get the length of the costs lists
        n = len(costs)
        # set the values for the three colors for last houses
        varR = costs[n-1][0]
        varB = costs[n-1][1]
        varG = costs[n-1][2]
        
        # loop from n-2th house to 1st house
        for i in range(n-2, -1, -1):
            # store the red and blue values in temp before overwriting
            tempR = varR
            tempB = varB
            # get the values for every color for the house
            varR = costs[i][0] + min(varB, varG)
            varB = costs[i][1] + min(tempR, varG)
            varG = costs[i][2] + min(tempR, tempB)
        # return min values of all three color
        return min(varR, min(varB, varG))

# Example usage:
# solution = Solution()
# print(solution.minCost([[17,2,17], [16,16,5], [14,3,19]]))
