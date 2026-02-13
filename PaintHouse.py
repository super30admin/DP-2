# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We work backwards from the last house.
# For each house, update the color costs based on the min of the other two colors from the next house.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        num_houses = len(costs)
        num_colors = len(costs[0])

        costR = costs[num_houses-1][0]
        costB = costs[num_houses-1][1]
        costG = costs[num_houses-1][2]


        for i in range(num_houses - 2, -1, -1):
            tempR = costR
            tempB = costB 

            costR = costs[i][0] + min(costB, costG)
            costB = costs[i][1] + min(tempR, costG)
            costG = costs[i][2] + min(tempR, tempB)

        return min(costR, costB, costG)       
        