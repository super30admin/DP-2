"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Approach:

Problem_1:  Paint House, There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different.
            You have to paint all the houses such that no two adjacent houses have the same color.
            The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
            For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
            You should return the minimum cost to paint all houses.
"""




class Sol:
    def minCost(self, costs):

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
            