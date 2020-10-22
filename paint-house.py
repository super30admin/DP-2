# Time Complexity:- O(len(costs)*3) We are iterating over the entire costs array and the no. of colours we have is 3
# Space Complexity:- O(len(costs)*3)
# Approach:- We have 2 options at every point which is based on what we have coloured the previous house,if we have coloured it
# red, the mincost is coloring that house red and the mincost of the colouring the next house blue or green
import sys

class Solution:
    def minCost(self, costs):
        if not costs or len(costs)==0:
            return 0
        @lru_cache(maxsize=None)
        def mc(previously_painted_house,n):
            if n==len(costs)-1:
                return costs[n][previously_painted_house]
            taken=taken1=taken2=sys.maxsize
            # previously painted house=red
            if previously_painted_house==0:
                # mincost at this point= painting the house red + minimum(painting the next house blue,painting the next house green )
                taken=min(costs[n][previously_painted_house]+mc(1,n+1),costs[n][previously_painted_house]+mc(2,n+1))
                # previously painted house=blue
            elif previously_painted_house==1:
                # mincost at this point= painting the house blue + minimum(painting the next house red,painting the next house green )
                taken1=min(costs[n][previously_painted_house]+mc(0,n+1),costs[n][previously_painted_house]+mc(2,n+1))
                # previously painted house=green
            elif previously_painted_house==2:
                # mincost at this point= painting the house green + minimum(painting the next house blue,painting the next house red )
                taken2=min(costs[n][previously_painted_house]+mc(0,n+1),costs[n][previously_painted_house]+mc(1,n+1))
            return min(taken,taken1,taken2)
        #get the overall minimum of painting the first house red,blue,green
        return min(mc(0,0),mc(1,0),mc(2,0))
        
        

sol=Solution()
print(sol.minCost([[3,5,3],[6,17,6],[7,13,18],[9,10,18]]))