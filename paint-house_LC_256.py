#TC:O(N)
#SC:O(1) if we can mutate the array (ask interviewer) O(n) if we can'the
#DP problem
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        selectedIdx = -1
        n = len(costs)-1

        for i,val in reversed(list(enumerate(costs))):
            if i<n:
                val[0] = min(val[0]+costs[i+1][1],val[0]+costs[i+1][2])
                val[1] = min(val[1]+costs[i+1][0] , val[1]+costs[i+1][2])
                val[2] = min(val[2]+costs[i+1][0] , val[2]+costs[i+1][1])
        print(min(costs[0][0],min(costs[0][1],costs[0][2])))
        return min(costs[0][0],min(costs[0][1],costs[0][2]))
    
