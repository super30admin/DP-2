"""
Time Complexity : Inside function
Space Complexity : Inside function
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes


Your code here along with comments explaining your approach

Problem_1:  Paint House, There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different.
            You have to paint all the houses such that no two adjacent houses have the same color.
            The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
            For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
            Return the minimum cost to paint all houses.
"""

# Approach - 1
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        """
        Exhaustive way - using recursion
        Time Complexity : O(2^n), n is the no of house
        space Complexity : O(n)
        """
        if len(costs) == 0: return 0
        
        pickR = self.helper(costs, 0, 0, 0)
        pickB = self.helper(costs, 1, 0, 0)
        pickG = self.helper(costs, 2, 0, 0)
        
        return min(pickR, min(pickB, pickG))
       
        
    def helper(self, costs, color, index, amount):
        #base case
        if index == len(costs): return amount
        
        
        #logic
        if (color == 0):
            return min(self.helper(costs, 1, index + 1, amount + costs[index][0]),
                       self.helper(costs, 2, index + 1, amount + costs[index][0]) )
                      
        if (color == 1):
            return min(self.helper(costs, 0, index + 1, amount + costs[index][1]),
                       self.helper(costs, 2, index + 1, amount + costs[index][1]) )
                       
                       
        if (color == 2):
            return min(self.helper(costs, 1, index + 1, amount + costs[index][2]),
                       self.helper(costs, 0, index + 1, amount + costs[index][2]) )
                      
                       
        return 

# Approach - 2

class Solution:
    def minCost(self, costs) -> int:
        """
        Bottoms up approach - Dp
        Time comp: O(n)
        Space comp: O(n)
        """
        if len(costs) == 0: return 0
        
        h = len(costs) 
        dp  = [[0 for i in range(3)] for j in range(h)]
        
        for i in range(0,3):
            dp[h-1][i] = costs[h-1][i]
   
        for i in range(h-2,-1,-1):
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
            dp[i][2] = costs[i][2] + min(dp[i + 1][1], dp[i + 1][0])
            
        return min(dp[0][0], min(dp[0][1], dp[0][2]))

# Approach - 3
class Sol:
    def minCost(self, costs):
        """
        Time comp: O(n)
        Space comp: O(1)
        """

        if len(costs) == 0: return 0
        
        h = len(costs) 
        c_red = costs[h - 1][0] 
        c_blue = costs[h - 1][1] 
        c_green = costs[h - 1][2] 
        
        for i in range(h-2,-1,-1):
            prev_r = c_red
            prev_b = c_blue
            
            c_red = costs[i][0] + min(c_blue, c_green)
            c_blue = costs[i][1]+ min(prev_r, c_green)
            c_green = costs[i][2] + min(prev_b, prev_r)
            
        return min(c_red, min(c_blue, c_green))