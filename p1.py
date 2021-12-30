"""

Given a row of n houses, each house can be coloured with any of the three colours: 
let these be red blue or green. the cost for painting a particular house with a particular 
colour is going to be different. you have to colour the house in such a way that no two 
adjacent houses will have the same colour. the cost for painting  a house with any colour 
is represented by a n X 3 cost matrix where cost for painting house 0 with colour red is cost[0][0] 
and cost for painting house 4 with green colour is cost[4][2] and so on.....calculate the minimum cost to paint all houses.
 try to optimize it for space !! 


// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

    
    """
class Solution(object):
    def minCost(costs, N):
   
    # Corner Case
        if N == 0:
            return 0
 
        # Auxiliary 2D dp array
        dp = [[0 for i in range(3)] for j in range(3)]
    
        # Base Case
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

               
        # If current house is colored
        # with red the take min cost of
        # previous houses colored with
        # (blue and green)