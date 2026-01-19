# 256. Paint House
# Bottom-Up Dynamic Programming
# Time Complexity: O(m), Space Complexity: O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        m = len(costs)
        # Initialize with the last house's costs
        costR, costG, costB = costs[m-1]

        # Move backwards through the houses
        for i in range(m - 2, -1, -1):
            tempR, tempG, tempB = costR, costG, costB
            # For each color, choose the minimum of the other two colors for the next house and add the current cost
            costR = costs[i][0] + min(tempG, tempB)
            costG = costs[i][1] + min(tempR, tempB)
            costB = costs[i][2] + min(tempR, tempG)

        # The minimum of the three options for the first house is the final answer
        return min(costR, costG, costB)
