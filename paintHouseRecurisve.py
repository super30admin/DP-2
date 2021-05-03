class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if not costs:
            return None
    
        case1 = self.helper(costs,0, 0, 0)     #choose red
        case2 = self.helper(costs,0, 1, 0)    #Choose blue
        case3 = self.helper(costs,0, 2, 0)    #choose green
        
        return min(case1, min(case2,case3))
    
    def helper(self, costs, row, color, currCost):
        
        if row==len(costs):
            return currCost
        
        if color==0:
            return min(self.helper(costs,row+1,1,currCost+costs[row][0]), self.helper(costs,row+1,2,currCost+costs[row][0]))
        
        if color==1:
            return min(self.helper(costs,row+1,0,currCost+costs[row][1]), self.helper(costs,row+1,2,currCost+costs[row][1]))
        
        if color==2:
            return min(self.helper(costs,row+1,0,currCost+costs[row][2]), self.helper(costs,row+1,1,currCost+costs[row][2]))
        

#  time complexity is exponential, we are creating exhaustive recursive tree for the problem, there are multiple repeated subProblems which
# can be removed by DP.
