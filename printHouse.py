# // Time Complexity : O(n) as N*3 matrix
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# DP solution
# find out the minimum cost in bottom up approach at each level
# by leaving the current column
# add smallest of those to the current colummn
# lastsly return minumum of last row

# Recursive solution
# Here there are 3 cases
# in that each case will have 2 cases
# calculate all the paths values and return the min


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if len(costs)==0 or costs == None: return 0
        g=costs[0][2]
        b=costs[0][1]
        r=costs[0][0]
        
        for i in range(1,len(costs)):
            tempR = r
            tempG = g
            tempB = b
            
            r = costs[i][0] + min(b,g)
            b = costs[i][1] + min(tempR, tempG)
            g = costs[i][2] + min(tempR, tempB)
                
        l=len(costs)-1
        return min(r,g,b)
    

    
    
#         def helper(costs, row, color, value):
#             #base
#             if row== len(costs):
#                 return value
#             #logic
#             case1 = float('inf')
#             case2 = float('inf')
#             case3 = float('inf')
#             #case1:
#             if color == 0:
#                 case2 = helper(costs, row+1, 1, value+costs[row][1])
#                 case3 = helper(costs, row+1, 2, value+costs[row][2])
#             if color == 1:
#                 case1 = helper(costs, row+1, 0, value+costs[row][0])
#                 case3 = helper(costs, row+1, 2, value+costs[row][2])
#             if color == 2:
#                 case1 = helper(costs, row+1, 0, value+costs[row][0])
#                 case2 = helper(costs, row+1, 1, value+costs[row][1])

#             return min(case1, case2, case3)
        
#         case1 = helper(costs, 0,0,0)
        
#         case2 = helper(costs, 0,1,0)
        
#         case3 = helper(costs, 0,2,0)
#         # print(case1)
#         # print(case2)
#         # print(case3)
        
#         return min(case1, case2, case3)