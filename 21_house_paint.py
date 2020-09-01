# S30 Big N Problem #21 {Easy}
# Leetcode #256

# Given a row of n houses, each house can be coloured with any of the three colours: 
# let these be red blue or green. the cost for painting a particular house with a particular colour is going to be different. 
# you have to colour the house in such a way that no two adjacent houses will have the same colour. 
# the cost for painting  a house with any colour is represented by a n X 3 cost matrix where cost for painting house 0 with colour red is cost[0][0] and cost for painting house 4 with green colour is cost[4][2] and so on.....
# calculate the minimum cost to paint all houses. try to optimize it for space !! 

# Time Complexity : O(n) n= no. of houses
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

#Approach:
# At any house, calculate the min. cost of painting the prev house of different colors.
# Add it to the cost of coloring the current house. 

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if len(costs)==0:
            return 0
        
        for i in range(1,len(costs),1):
                
            costs[i][0]=min(costs[i-1][1],costs[i-1][2])+costs[i][0]
            costs[i][1]=min(costs[i-1][0],costs[i-1][2])+costs[i][1]
            costs[i][2]=min(costs[i-1][1],costs[i-1][0])+costs[i][2]
            
        
        return min(costs[len(costs)-1])
                
        