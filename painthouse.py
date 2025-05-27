class Solution:
    def minCost(self,costs):
        if not costs:
            return 0
        
        n=len(costs)

        for i in range(1,n):
            costs[i][0]+=min(costs[i-1][1],costs[i-2][2])
            costs[i][1]+=min(costs[i-1][0],costs[i-1][2])
            costs[i][2]+=min(costs[i-1][0],costs[i-1][1])
        return min(costs[-1])
    
sol=Solution()
print(sol.minCost([[14,2,11],[11,14,5],[14,6,23]]))
print(sol.minCost([[11,14,5]]))
print(sol.minCost([[21,6,23]]))