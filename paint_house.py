#Time Complexity :  O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs)==0:
            return 0

        previous_row = costs[-1]

        for n in reversed(range(len(costs) - 1)):
            costs[n][0] = costs[n][0]+min(costs[n+1][1],costs[n+1][2])
            costs[n][1] = costs[n][1]+min(costs[n+1][0],costs[n+1][2])
            costs[n][2] = costs[n][2]+min(costs[n+1][0],costs[n+1][1])

        return min(costs[0])

        
        