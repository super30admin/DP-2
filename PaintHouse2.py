#Time Complexity : O(MN)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == [] or len(costs) == 0:
            return 0

        costR, costB, costG = costs[len(costs)-1][0], costs[len(costs)-1][1], costs[len(costs)-1][2]
        for i in range(len(costs)-2,-1,-1):
            tempR = costR
            tempB = costB
            costR = costs[i][0] + min(costG, costB)
            costB = costs[i][1] + min(tempR, costG)
            costG = costs[i][2] + min(tempR, tempB)
        print(costR, costB, costG)
        return min(costR, costG, costB) 