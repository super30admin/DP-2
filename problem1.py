# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        dpMap = [[0 for _ in range(len(costs[0]))] for _ in range(len(costs))]
        dpMap[0] = costs[0]
        
        for i in range(1, len(costs)):
            for j in range(len(costs[0])):
                if j == 0:
                    extra = min(dpMap[i-1][j+1:])
                elif j == len(costs[i]) -1:
                    extra = min(dpMap[i-1][:j])
                else:
                    extra = min(min(dpMap[i-1][j+1:]), min(dpMap[i-1][:j]))
                dpMap[i][j] = costs[i][j] + extra
            
        return min(dpMap[-1])