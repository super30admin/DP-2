# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if (len(costs) == 0):
            return 0
        for i in range(len(costs) - 2, -1, -1):
            costs[i][2] = costs[i][2] + min(costs[i + 1][0], costs[i + 1][1])
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2])
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2])

        return min(costs[0]) #Minimum of row 0 gives the answer
