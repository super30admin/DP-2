# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I needed to make sure adjacent houses never use the same color.
# Approach: I tracked the minimum cost to paint up to the current house ending in each color.
# For each new house, each color can only come from the cheaper of the other two previous colors.
# The answer is the smallest of the three final color costs.


class Solution:

    def minCost(self, costs):
        if not costs:
            return 0

        red = 0
        blue = 0
        green = 0

        for cost_red, cost_blue, cost_green in costs:
            new_red = cost_red + min(blue, green)
            new_blue = cost_blue + min(red, green)
            new_green = cost_green + min(red, blue)

            red = new_red
            blue = new_blue
            green = new_green

        return min(red, blue, green)
