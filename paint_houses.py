# Time Complexity : O(n) because we are iterating through the array only once
# Space Complexity : O(1) because we are not using any extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""In this code we create a bottom-up iterative approach to get the get the minimum cost to paint the houses"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0

        n = len(costs)

        for i in range(n-2, -1, -1): 
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][1], costs[i+1][0])

        return min(costs[0][0], costs[0][1], costs[0][2])

