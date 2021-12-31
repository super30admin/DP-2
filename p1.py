"""
<<<<<<< HEAD
=======

>>>>>>> d96a512abec57b0f2391872dce2a4235e50c43bf
Given a row of n houses, each house can be coloured with any of the three colours: 
let these be red blue or green. the cost for painting a particular house with a particular 
colour is going to be different. you have to colour the house in such a way that no two 
adjacent houses will have the same colour. the cost for painting  a house with any colour 
is represented by a n X 3 cost matrix where cost for painting house 0 with colour red is cost[0][0] 
and cost for painting house 4 with green colour is cost[4][2] and so on.....calculate the minimum cost to paint all houses.
 try to optimize it for space !! 
<<<<<<< HEAD
// Time Complexity : O(N)
// Space Complexity : O(1) a 2d array was initialized
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
=======

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
        for i  in range(0, N):
            dp[i][0] = min( dp[i-1][1], dp[i-1][2]) + costs[i][0] 
            #blue house
            dp[i][1] = min( dp[i-1][0], dp[i-1][2]) + costs[i][1] 
            #green
            dp[i][2] = min( dp[i-1][0], dp[i-1][1]) + costs[i][2] 

        #print min of the last digit of 3 colored path
        #min() only takes 2 values
        print(min(dp[N-1][0], min(dp[N-1][1],dp[N-1][2])))

    if __name__ == '__main__':
        costs = [[14, 21, 11],
                [11, 14, 5],
                [14, 3, 10]]
        N = len(costs)
        
        # Function Call
        minCost(costs, N)
