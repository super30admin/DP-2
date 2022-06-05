# // Time Complexity : O(3^N) (exponential since we are iterating over all the possiblilites)
# // Space Complexity : stack space for all the calls at max time they will be half of the tree(O(N))
# // Did this code successfully run on Leetcode : No (TLE)
# // Any problem you faced while coding this : Nope
class RecursiveSolution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        return min(self.helper(costs, 0, 0, 0),
                   self.helper(costs,0, 1, 0),
                   self.helper(costs,0, 2,0 ))
    def helper(self, costs, house, color, paintCost):
        if house >= len(costs):
            return paintCost
        cRed = cBlue = cGreen = float('inf')
        if color == 0:
            cRed = min(self.helper(costs, house+1, 1, paintCost+costs[house][color]),
                self.helper(costs, house+1, 2, paintCost+costs[house][color]))
        if color == 1:
            cBlue = min(self.helper(costs, house+1, 0, paintCost+costs[house][color]),
                self.helper(costs, house+1, 2, paintCost+costs[house][color]))
        if color == 2:
            cGreen = min(self.helper(costs, house+1, 1, paintCost+costs[house][color]),
                self.helper(costs, house+1, 0, paintCost+costs[house][color]))
        return min(cRed,cBlue,cGreen)

# // Time Complexity :O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope
class DPSolution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        dp = [[0] * len(costs[0]) for i in range(len(costs))]
        rows = len(costs) - 1
        cols = len(costs[0]) - 1
        for i in range(cols + 1):
            dp[rows][i] = costs[rows][i]
        print(dp)

        for i in range(rows - 1, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
            dp[i][2] = costs[i][2] + min(dp[i + 1][1], dp[i + 1][0])
        return min(dp[0])