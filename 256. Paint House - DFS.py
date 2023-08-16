# Using DFS
# Time Complexity = 3*(2^len(costs))
# Space Complexity = len(costs)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        costR = self.helper(costs,0,0,0) # 0
        costB = self.helper(costs,0,1,0) # 1
        costG = self.helper(costs,0,2,0) # 2
        return min(costR,costB,costG)

    def helper(self,costs,house_idx,color,amount):
        # base
        if house_idx == len(costs):
            return amount
        # logic
        if color == 0:
            return min(self.helper(costs,house_idx+1,1,amount+costs[house_idx][1]),self.helper(costs,house_idx+1,2,amount+costs[house_idx][2]))
        if color == 1:
            return min(self.helper(costs,house_idx+1,0,amount+costs[house_idx][0]),self.helper(costs,house_idx+1,2,amount+costs[house_idx][2]))
        if color == 2:
            return min(self.helper(costs,house_idx+1,1,amount+costs[house_idx][1]),self.helper(costs,house_idx+1,0,amount+costs[house_idx][0]))