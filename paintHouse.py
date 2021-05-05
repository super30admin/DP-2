"""
Intuition:  Check greedy. Greedy will fail.

We will have to browse all possible comvbinations. (Be exhaustive)

After drawing the recursive tree,we will notice the subproblems.

eg: if given costs = costs = [[17,2,17],[16,16,5],[14,3,19]]

Recursive tree: 17             
                / \
               16   5 
               /\  / \
              14 19 14 3  


                 2             
                / \
               16   5 
               /\  / \
              3 19 14 3 
We can notice how for subtree 5 we have a repeated subproblem.

Start by using a bottom up approach to create the mincost matrix. (we can also do top down)
#####################################################################
For Recursive: 2 decisions are made at every row.
Time Complexity : O(2^N)  N = number of rows
Space Complexity : O(2^N) 
#####################################################################
For DP Approach: Both top to bottom & bottom to top
Time Complexity : O(N)  N = number of rows
Space Complexity : O(1) 
#####################################################################
"""
#Recursive

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        case1 = self.helper(costs, 0, 0, 0)
        case2 = self.helper(costs, 0, 1, 0)
        case3 = self.helper(costs, 0, 2, 0)
        return min(case1, case2, case3)
    
    def helper(self, costs, row, color, currentCost):
        
        if row == len(costs):
            return currentCost
        
        if color == 0:
            return min(self.helper(costs, row + 1, 1, currentCost + costs[row][0]) , self.helper(costs, row + 1, 2, currentCost + costs[row][0]))
    
        if color == 1:
            return min(self.helper(costs, row + 1, 0, currentCost + costs[row][1]) , self.helper(costs, row + 1, 2, currentCost + costs[row][1]))
        
        return min(self.helper(costs, row + 1, 0, currentCost + costs[row][2]) , self.helper(costs, row + 1, 1, currentCost + costs[row][2]))
            

#Bottom Up
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        
        for index in range(len(costs)-2, -1,-1):
            
            
            costs[index][0] = costs[index][0] + min(costs[index+1][1], costs[index+1][2])
            costs[index][1] = costs[index][1] + min(costs[index+1][0], costs[index+1][2])
            costs[index][2] = costs[index][2] + min(costs[index+1][1], costs[index+1][0])
        
        
        return min(costs[0])

#Top down
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        
        for index in range(1, len(costs)):
            
            
            costs[index][0] = costs[index][0] + min(costs[index-1][1], costs[index-1][2])
            costs[index][1] = costs[index][1] + min(costs[index-1][0], costs[index-1][2])
            costs[index][2] = costs[index][2] + min(costs[index-1][1], costs[index-1][0])
        
        
        return min(costs[len(costs)-1])