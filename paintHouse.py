# Time Complexity : O(n*3) where n is the number of houses
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Dynamic Programming
# 1. We will start from the second last row and calculate the minimum cost of painting the house with the current color.
# 2. We will add the minimum cost of painting the house with the current color to the cost of painting the house with the next color.
# 3. We will repeat this process for all the houses and colors.
# 4. Finally, we will return the minimum cost of painting the first house.

from typing import List
class Solution:
    def paintHouse(self, costs: List[List[int]]) -> int:
        n = len(costs)
        # Initialize a path matrix to keep track of what color each house is painted with
        path = [[0 for _ in range(3)] for _ in range(n)]
        for i in range(len(costs)-2, -1, -1):
            for j in range(3):
                # Update the path matrix based on the minimum cost of painting the next house
                if costs[i+1][1] < costs[i+1][2]:
                    path[i][0] = 1
                else:
                    path[i][0] = 2
                if costs[i+1][0] < costs[i+1][2]:
                    path[i][1] = 0
                else:
                    path[i][1] = 2
                if costs[i+1][0] < costs[i+1][1]:
                    path[i][2] = 0
                else:
                    path[i][2] = 1

                # if the current color is red, we can choose blue or green for the next house, and update the cost
                if j == 0:
                    costs[i][j] += min(costs[i+1][1], costs[i+1][2])
                # if the current color is blue, we can choose red or green for the next house, and update the cost
                if j == 1:
                    costs[i][j] += min(costs[i+1][0], costs[i+1][2])
                # if the current color is green, we can choose red or blue for the next house, and update the cost
                if j == 2:
                    costs[i][j] += min(costs[i+1][0], costs[i+1][1])

        # Find the minimum cost of painting the first house
        if path[0][0] < path[0][1] and path[0][0] < path[0][2]:
            idx = 0
        elif path[0][1] < path[0][0] and path[0][1] < path[0][2]:
            idx = 1
        elif path[0][2] < path[0][1] and path[0][2] < path[0][0]:
            idx = 2
        i = 0
        # Print the path of colors for each house
        while i < n:
            print(idx)
            idx = path[i][idx]
            i += 1

        # return the minimum cost of painting the first house
        return min(costs[0])

# Approach: Space optimized DP
# Time Complexity: O(n) where n is the number of houses
# Space Complexity: O(1)
# We keep track of the R, B, G values for the previous house and update the values for the current house.  
class Solution:
    def paintHouse(self, costs: List[List[int]]) -> int:
        n = len(costs)
        dp = [i for i in costs[n-1]]
        for i in range(len(costs)-2, -1, -1):
            tmpR = dp[0]
            tmpB = dp[1]
            dp[0] = costs[i][0] + min(dp[1], dp[2])
            dp[1] = costs[i][1] + min(tmpR, dp[2])
            dp[2] = costs[i][2] + min(tmpR, tmpB)

        return min(dp)


# Approach: Recursion
# Time Complexity: O(2^n*3) where n is the number of houses
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : No, TLE

class Solution:
    def paintHouse(self, costs: List[List[int]]) -> int:
        colorR = self.helper(costs, 0, 0, 0)
        colorB = self.helper(costs, 0, 1, 0)
        colorG = self.helper(costs, 0, 2, 0)
        return min(colorR, colorB, colorG)
    # helper function to calculate the minimum cost
    def helper(self, costs, h, c, totalCost):
#        base case
        if h == len(costs):
            return totalCost
#        logic
        # if the current color is red, we can choose blue or green for the next house, and return the minimum cost
        if c == 0:
            return min(self.helper(costs, h+1, 1, totalCost+costs[h][0]), 
                         self.helper(costs, h+1, 2, totalCost+costs[h][0]))
        # if the current color is blue, we can choose red or green for the next house, and return the minimum cost
        if c == 1:
            return min(self.helper(costs, h+1, 0, totalCost+costs[h][1]),
                         self.helper(costs, h+1, 2, totalCost+costs[h][1]))
        # if the current color is green, we can choose red or blue for the next house, and return the minimum
        if c == 2:
            return min(self.helper(costs, h+1, 0, totalCost+costs[h][2]),
                         self.helper(costs, h+1, 1, totalCost+costs[h][2]))