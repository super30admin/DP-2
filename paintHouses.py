# Time Complexity : O(N) where N = # of rows
# Space Complexity : O(N * 3)  where N = # of rows
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I made the mistake of adding the costs of the
# same row, i, instead of i + 1


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if len(costs) == 0 or costs is None:
            return 0

        for i in range(len(costs) - 2, -1, -1):
            
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])
            
        return min(costs[0][0], min(costs[0][1], costs[0][2]))