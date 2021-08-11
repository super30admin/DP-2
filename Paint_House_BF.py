# The solution below takes the BF approach
# However, it fails to perform on all the cases.
# Time complexity is Exponential 3^n and space complexity is exponential as well

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs: return 0
        case1 = self.helper(costs,row=0, col=0,mincost=0)
        case2 = self.helper(costs,row=0, col=1,mincost=0)
        case3 = self.helper(costs,row=0, col=2,mincost=0)
        return min(case1,case2,case3)

    def helper(self,costs,row,col,mincost):
        # Base Case
        if row == len(costs): return mincost

        # Logic
        if col ==0:
            return min( self.helper(costs, row+1, col+1, mincost+costs[row][col]), self.helper(costs,row+1, col+2, mincost + costs[row][col]))
        if col ==1:
            return min( self.helper(costs, row+1, col-1, mincost+costs[row][col]), self.helper(costs,row+1, col+1, mincost + costs[row][col]))
        if col ==2:
            return min( self.helper(costs, row+1, col-1, mincost+costs[row][col]), self.helper(costs,row+1, col-2, mincost + costs[row][col]))
