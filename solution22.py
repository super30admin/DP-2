#Time Complexity:O(3n)
#Space Complexity:O(1)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(len(costs)==0):
            return 0
        for i in range(1,len(costs)):
            colours=costs[i]
            prev=costs[i-1]
            colours[0]=colours[0]+min([prev[1],prev[2]])
            colours[1]=colours[1]+min([prev[0],prev[2]])
            colours[2]=colours[2]+min([prev[0],prev[1]])
        return min(costs[-1])