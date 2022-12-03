# // Time Complexity : O(n) --> n--> len(costs)
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# // Your code here along with comments explaining your approach

## we see that greedy does not work here as we cannot really choose maximum at every stage and reach an optimal solution.
## i.e we can chose a min number at start but later it might become large. SO we have to for exhaustive solution.
## we have to find all the ways possible until we reach the last house, and the then we pick that way which gives the min cost.
## we optimize the space here by using just 3 variables at a time. for a particular house we add the minimum cost of the previous house excluding the current color, to this house, we keep doing this for all the houses. 
## until we reach the last, once we reach the last house , we get the minimum.

class solution:
    def paintHouse(self, costs):

        valR = costs[0][0]
        valB = costs[0][1]
        valG = costs[0][2]

        for i in range(1, len(costs)):
            tempR = valR
            valR  = costs[i][0]+min(valB, valG)
            tempB = valB
            valB  = costs[i][1]+min(tempR, valG)
            valG  = costs[i][2]+ min(tempR, tempB)
        
        return min(valR, valB, valG) 

