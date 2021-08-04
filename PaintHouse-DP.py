"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        # Going top down in a matrix calculating the minimum costs
        for i in range(1,len(costs)):
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])
        # Final answer would be the minimum of elements in last row
        return min(costs[len(costs) - 1][0], costs[len(costs) - 1][1], costs[len(costs) - 1][2])
           