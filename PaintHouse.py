'''
time complexity: o(len(list))
space complexity: O(1)
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs==None or len(costs)==0  ):
            return 0
        
        n = len(costs)
        costR = costs[n-1][0]
        costG = costs[n-1][1]
        costB = costs[n-1][2]
        
        
        for i in range(n-2,-1,-1):
            tempR = costR
            tempG = costG
            costR = costs[i][0] + min(tempG,costB)
            costG = costs[i][1] + min(tempR,costB)
            costB = costs[i][2] + min(tempR,tempG)
        return min(costR,costG,costB)