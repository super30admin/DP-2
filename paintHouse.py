# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : y
# Any problem you faced while coding this : n


# Your code here along with comments explaining your approach

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        
        for i in reversed(range(len(costs)-1)):
            costs[i][0] += min(costs[i+1][1], costs[i+1][2])
            costs[i][1] += min(costs[i+1][0], costs[i+1][2])
            costs[i][2] += min(costs[i+1][1], costs[i+1][0])
        
        return min(costs[0])


# if we create a tree, ew will observe that values at the bottom of the tree are repeated. Hence, using bottom up approach 
# while mutating the matrix to find min cost