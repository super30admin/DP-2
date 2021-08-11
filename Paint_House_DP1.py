# Dynamic Programing approach
# Time complexity O(n)
# Space Complexity O(1)
# In this approach we are modifying the given costs array

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs: return 0
        for i in range(len(costs)-2,-1,-1):
            costs[i][0] += min(costs[i+1][1],costs[i+1][2])
            costs[i][1] += min(costs[i+1][0],costs[i+1][2])
            costs[i][2] += min(costs[i+1][1],costs[i+1][0])
        return min (costs[0][0], costs[0][1],costs[0][2])


# The range function is different here than what Professor had suggested.
# He had the range set from len(costs)- 2, 0. However in Python I have to set the limit to -1 in order to include the 0th row.
