#  Time Complexity : O(n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) == 0:
            return 0
        
        # iterate and select the min for previous house cost in each pass of the house for each colour
        for i in range(1,len(costs)):
        # if house is painted red
            costs[i][0] += min(costs[i-1][1],costs[i-1][2])
        # if house is painted blue
            costs[i][1] += min(costs[i-1][2],costs[i-1][0])
        # if house is painted green
            costs[i][2] += min(costs[i-1][1],costs[i-1][0])
            
        # return the least colour cost
        return min(costs[len(costs) - 1])