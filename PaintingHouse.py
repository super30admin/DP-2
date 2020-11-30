# Time Complexity : O(N) where n is the number

#  Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#I I am updating the original array with the  minimum costs

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0

        for i in range(1, len(costs)):
            costs[i][0] = costs[i][0] + min(costs[i - 1][1], costs[i - 1][2])
            costs[i][1] = costs[i][1] + min(costs[i - 1][0], costs[i - 1][2])
            costs[i][2] = costs[i][2] + min(costs[i - 1][0], costs[i - 1][1])

        return min(costs[-1][0], min(costs[-1][1], costs[-1][2]))