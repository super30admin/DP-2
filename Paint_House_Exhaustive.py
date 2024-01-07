"""
Time Complexity : O(2^3n) where n is the total number of houses. 2 because of two choices we make (choose the color or not choose the color) and 3*n as we have three choises for each home
Space Complexity : O(2^3n) as we are creating this much number of nodes
Did this code successfully run on Leetcode : Time Limit Exceeded
Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
1. Greedy fails so we should try Exhaustive search
2. In exhaustive search we create each and every path and find the optimum answer in all the possible paths
"""


class Solution:
    def helper(self, color, costs, row, amount):
        # base case
        if row == len(costs):
            return amount

        # logic
        if color == 0:
            # Red
            green = self.helper(1, costs, row + 1, amount + costs[row][0])
            blue = self.helper(2, costs, row + 1, amount + costs[row][0])
            return min(green, blue)
        elif color == 1:
            # Green
            red = self.helper(0, costs, row + 1, amount + costs[row][1])
            blue = self.helper(2, costs, row + 1, amount + costs[row][1])
            return min(red, blue)
        elif color == 2:
            # Blue
            green = self.helper(1, costs, row + 1, amount + costs[row][2])
            red = self.helper(0, costs, row + 1, amount + costs[row][2])
            return min(red, green)

    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        print(len(costs))
        red = self.helper(0, costs, 0, 0)
        green = self.helper(1, costs, 0, 0)
        blue = self.helper(2, costs, 0, 0)

        return min(red, green, blue)
