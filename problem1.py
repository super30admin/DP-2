#Time Complexity O(n)
#Space Complexity O(1) constant (No additional space)

class Solution:
#     def getMin(self,costs,ind, color_ind,total_cost):
        
#         # Base Case
#         if ind == len(costs):
#             return total_cost
        
        
#         # Logic
        
#         if color_ind == 0:
#             return min(self.getMin(costs,ind+1,1,total_cost + costs[ind][0]),
#                       self.getMin(costs,ind+1,2,total_cost + costs[ind][0]))
        
#         if color_ind == 1:
#             return min(self.getMin(costs,ind+1,0,total_cost + costs[ind][1]),
#                       self.getMin(costs,ind+1,2,total_cost + costs[ind][1]))
        
#         if color_ind == 2:
#             return min(self.getMin(costs,ind+1,0,total_cost + costs[ind][2]),
#                       self.getMin(costs,ind+1,1,total_cost + costs[ind][2]))
            
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None and len(costs)==0:
            return 0
        
        for x in range(len(costs) -2 ,-1,-1):
            costs[x][0] += min(costs[x+1][1],costs[x+1][2])
            costs[x][1] += min(costs[x+1][0],costs[x+1][2])
            costs[x][2] += min(costs[x+1][0],costs[x+1][1])
        
        return min(costs[0][0],min(costs[0][1],costs[0][2]))
        
        
        
        
        
        
        
        
#         case1 = self.getMin(costs,0,0,0)
#         case2= self.getMin(costs,0,1,0)
#         case3= self.getMin(costs,0,2,0)
        
#         return min(case1, min(case2,case3))
        
