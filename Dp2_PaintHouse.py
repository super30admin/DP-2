class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        length = len(costs)
        if length == 0:
            return 0
     # Looking Backwards for the minimum sum. That's why iterating from 1 and seeing previous iteration
        for x in range(1,length):
            costs[x][0] = costs[x][0] + min(costs[x-1][1],costs[x-1][2])
            costs[x][1] = costs[x][1] + min(costs[x-1][0],costs[x-1][2])
            costs[x][2] = costs[x][2] + min(costs[x-1][0],costs[x-1][1])
            
        return min(costs[length-1][0],costs[length-1][1],costs[length-1][2])
    
        """
        Time Complexity - O(n)
        Space Complexity - O(1)
        Did this code successfully run on Leetcode- Yes :
        Any problem you faced while coding this- No :
        """
            