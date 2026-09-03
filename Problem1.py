# Problem1 (https://leetcode.com/problems/paint-house/)
# Time Complexity: O(m), we iterate through the houses once, from the last house to the first, doing constant work (3 color updates) per house
# Space Complexity: O(1), we only use a fixed number of scalar variables (colorR, colorB, colorG,tempR, tempB) no matter how many houses there are
# Approach:
# We work backwards from the last house, keeping just 3 running variables, one per color.
# Each variable holds the cheapest way to paint that house AND all houses after it,assuming that house is painted with that color.
# For each earlier house, we recompute the 3 variables using the two OTHER colors' values from the house after it (since adjacent houses cannot share a color).
# By the time we reach house 0, the 3 variables hold the total cost of painting ALL houses, so we return the minimum of the three.

class Solution:
    def minCost(self, costs):
        m = len(costs)              # number of houses
        n = len(costs[0])           # number of colors, always 3 here

        # base case: for the last house, cost of finishing from here is just its own paint cost
        colorR = costs[m-1][0]      # cheapest total if last house is red
        colorB = costs[m-1][1]      # cheapest total if last house is blue
        colorG = costs[m-1][2]      # cheapest total if last house is green

        # move backwards from the second to last house down to house 0
        for i in range(m-2, -1, -1):
            # save the old colorR and colorB before they get overwritten below
            # these still represent house i+1 values and are needed later in this same step
            tempR = colorR
            tempB = colorB

            # if house i is red, house i+1 must be blue or green, so add the cheaper of those
            # colorB and colorG on the right side are still house i+1 values here, not yet touched
            colorR = costs[i][0] + min(colorB, colorG)

            # if house i is blue, house i+1 must be red or green
            # colorR was just overwritten above so we use tempR instead, colorG is still safe to use
            colorB = costs[i][1] + min(tempR, colorG)

            # if house i is green, house i+1 must be red or blue
            # both colorR and colorB have already been overwritten above, so use the saved temps
            colorG = costs[i][2] + min(tempR, tempB)

        # house 0 has no house before it, so it can be any color
        # return whichever color gives the lowest total cost for painting all houses
        return min(colorR, colorB, colorG)