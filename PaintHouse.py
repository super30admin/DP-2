# TC: O(n)
# SC = O(1)
# First we try with mutation of original matrix- which is not good practice. If we do a recursion tree for each of the starting points(i.e first house-red, blue, green)- we see different paths for painting for all houses. There are repeatation of many subproblems which can be stored to increase TC. As we are always considering 3 values each time- we do not need a DS or mutation- we an instead use 3 variables to store 3 latest costs of each of the paths at each level.

class Solution:
    def minCost(self, costs):
        # Mutation of original matrix
#         if costs == None or len(costs) == 0: return 0
#         for i in range(len(costs)-2,-1,-1):
#             costs[i][0] += min(costs[i+1][1],costs[i+1][2])
#             costs[i][1] += min(costs[i+1][0],costs[i+1][2])
#             costs[i][2] += min(costs[i+1][0],costs[i+1][1])
#         return min(costs[0][0], costs[0][1], costs[0][2])
        
        # avoiding mutation
        if costs == None or len(costs) == 0: return 0
        cr = costs[len(costs)-1][0]
        cb = costs[len(costs)-1][1]
        cg = costs[len(costs)-1][2]
        for i in range(len(costs)-2,-1,-1):
            tempr = cr
            tempb = cb
            cr = costs[i][0] + min(cb, cg)
            cb = costs[i][1] + min(tempr, cg)
            cg = costs[i][2] + min(tempr, tempb)
        return min(cr, cb, cg)
        
            
            