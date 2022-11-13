# Time Complexity : O(n) since there are fixed 3 colors so it will be 3n -> n
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0 or costs == None:
            return 0

        n = len(costs)

        # Here we use a Bottom-up DP approach
        # starting from the 2nd last row: we iterate over the columns
        # (since we can't use the same color for adjacent houses)
        # and add the minimum amount from the remaining colors to the current columns value
        # finally we will have the total minimum costs for each of the min paths in the 0th row
        # and we return whichever is the minimum out of the 3
        for i in reversed(range(0,n-1)):
            costs[i][0] += min(costs[i+1][1], costs[i+1][2])
            costs[i][1] += min(costs[i+1][0], costs[i+1][2])
            costs[i][2] += min(costs[i+1][0], costs[i+1][1])

        min_sum:int = sys.maxsize

        for i in costs[0]:
            min_sum = min(min_sum, i)

        return min_sum