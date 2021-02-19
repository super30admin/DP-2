#Time Complexity :  O(n) (where n = number of houses)
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Approach : Mutate row wise the cost array by storing the sum.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs is None or len(costs) == 0:
            return 0
        
        rows = len(costs)
        for i in range(1, rows):
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            costs[i][2] = costs[i][2] + min(costs[i-1][0], costs[i-1][1])
        
        return min(costs[rows-1][0], min(costs[rows-1][1], costs[rows-1][2]))