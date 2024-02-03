# Time complexity - O(n) n is the number of houses that need to paint
# Space complexity - O(1) used three variable only. So constant space complexity

# Problem
# There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

# The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

# For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
# Return the minimum cost to paint all houses.


# Example 1:

# Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
# Output: 10
# Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
# Minimum cost: 2 + 5 + 3 = 10.

class Solution:
    def minCost(self, costs: list[list[int]]) -> int:
        # Recusrion approach
        # red = self.helper(costs, 0, 0, costs[0][0])
        # blue = self.helper(costs, 0, 1, costs[0][1])
        # green = self.helper(costs, 0, 2, costs[0][2])
        # return min(red, min(blue, green))

        R = costs[0][0]
        B = costs[0][1]
        G = costs[0][2]

        # Here I am updating the value of each color
        # by comparing cost of not choosen two colors from previous house and update the minimum value
        # At last I am checking which took the cheapest path by comparing
        for i in range(1, len(costs)):
            tempR = R
            tempB = B
            R = costs[i][0] + min(B, G)
            B = costs[i][1] + min(tempR, G)
            G = costs[i][2] + min(tempR, tempB)

        return (min(R, min(G, B)))

    def helper(self, costs, houseIdx, colorIdx, costTillNow):
        # Base Case
        if houseIdx + 1 == len(costs):
            return costTillNow

        # Logic
        if colorIdx == 0:
            R1 = self.helper(costs, houseIdx + 1, 1,
                             costTillNow + costs[houseIdx + 1][1])
            R2 = self.helper(costs, houseIdx + 1, 2,
                             costTillNow + costs[houseIdx + 1][2])
            return min(R1, R2)
        elif colorIdx == 1:
            B1 = self.helper(costs, houseIdx + 1, 0,
                             costTillNow + costs[houseIdx + 1][0])
            B2 = self.helper(costs, houseIdx + 1, 2,
                             costTillNow + costs[houseIdx + 1][2])
            return min(B1, B2)
        elif colorIdx == 2:
            G1 = self.helper(costs, houseIdx + 1, 0,
                             costTillNow + costs[houseIdx + 1][0])
            G2 = self.helper(costs, houseIdx + 1, 1,
                             costTillNow + costs[houseIdx + 1][1])
            return min(G1, G2)
