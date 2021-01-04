# Time Complexity : O(n) - finding minimum of two values and adding it to other is O(1) we will do this for all 3 variable so it's O(n) 
# Space Complexity : O(1) - We don't allocate any new data structures, and are only using a few local variables. the algorithm is in-place, requiring constant extra space.  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        #Base Case
        if costs == None or len(costs) == 0:
            return 0
        
        #Bottom- up approach
        for i in reversed(range(len(costs) - 1)):
            #red Color
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            #green Color
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            #blue Color
            costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])
        
        # Return min value of costs
        return min(costs[0][0], costs[0][1], costs[0][2])
