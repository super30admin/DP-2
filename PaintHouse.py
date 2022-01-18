# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def minCost(self,costs):
        if costs == None or len(costs)==0:
            return 0

        for i in range(len(costs)-2, -1,-1):
            costs[i][0] += min(costs[i+1][1], costs[i+1][2])
            costs[i][1] += min(costs[i+1][0], costs[i+1][2])
            costs[i][2] += min(costs[i+1][0], costs[i+1][1])

        return min(costs[0][0],min(costs[0][1],costs[0][2]))