# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs is None or len(costs) == 0:
            return 0
        
        last0 = costs[0][0]
        last1 = costs[0][1]
        last2 = costs[0][2]
        
        for i in range(1, len(costs)):
            curr0 = costs[i][0] + min(last1, last2)
            curr1 = costs[i][1] + min(last0, last2)
            curr2 = costs[i][2] + min(last0, last1)
            
            last0 = curr0
            last1 = curr1
            last2 = curr2
        
        return min(last0, last1, last2)
