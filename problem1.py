"""
Approch: if in current home used color i then in the next home use color j != i. Get the min of all
by trying all possible ways. memoize it since it has overlapping subproblems.
"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        dp = [[-1 for i in range(3)] for j in range(n)]

        def recurse(index, color):
            if index == 0:
                minVal = 21
                for i in range(3):
                    if i == color:
                        continue
                    minVal = min(minVal, costs[index][i])
                return minVal
            if dp[index][color] != -1:
                return dp[index][color]

            minVal = (21*101)
            for i in range(3):
                if i == color:
                    continue
                minVal = min(minVal, costs[index][i] + recurse(index - 1, i))
            dp[index][color] = minVal
            return minVal
        return recurse(n - 1, -1)

