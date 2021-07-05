# time complexity = O(n)
# space complexity = O(1)
class Solution(object):
    def minCost(self,costs):
        #baseCondition
        if not costs:
            return None
        tempR = costs[0][0]
        tempB = costs[0][1]
        tempG = costs[0][2]
        for i in range(1,len(costs)):
            currR = costs[i][0]+ min(tempB,tempG)
            currB = costs[i][1]+ min(tempR,tempG)
            currG = costs[i][2] +min(tempR,tempB)
            
            tempR = currR
            tempB = currB
            tempG = currG
        return min(tempR,tempB,tempG)
obj = Solution()
costs = [[17,2,17],[16,16,5],[14,3,19]]
print(obj.minCost(costs))