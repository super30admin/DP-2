# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I will maintain three variables to keep track of the minimum cost to paint up to the current house with each color.
# At each house, I have three choices: paint it red, blue, or green.
# I will update the three variables accordingly as I iterate through the list of house costs.
# I will choose the color that results in the minimum cost. And then in the end return the min of the three colors

from typing import List
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        colorR = costs[len(costs)- 1][0]
        colorB = costs[len(costs)- 1][1]
        colorG = costs[len(costs)- 1][2]
        
        for i in range(len(costs) -2,-1,-1):
            tempR = colorR
            tempB = colorB
            colorR = costs[i][0] + min(colorB,colorG)
            colorB = costs[i][1] + min(tempR,colorG)
            colorG = costs[i][2] + min(tempR,tempB)
        return min(colorR,colorB,colorG)
