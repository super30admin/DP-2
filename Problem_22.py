# Time Complexity : O(n) where n is the length of the list nums
# Space Complexity : Constant auxiliary space needed as we only use a few variables
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        if not n:
            return
        rCost = costs[n-1][0] # Initialize rCost, bCost and cCost to their respective costs in the last row
        bCost = costs[n-1][1]
        gCost = costs[n-1][2]
        
        for i in range(n-2,-1,-1):
            # Iterate backwards from n-2 to 0
            tempR = rCost # Store in temp variables as their value will change in the middle of operations
            tempB = bCost
            tempG = gCost
            
            rCost = costs[i][0]+ min(tempB,tempG) # rCost will be cost of red paint for current house + min of Cost among Blue and Green paints for the next house
            bCost = costs[i][1]+ min(tempR,tempG)
            gCost = costs[i][2]+ min(tempR,tempB)
        
        return min(rCost,bCost,gCost) # Return whichever path leads to lowest cost
            