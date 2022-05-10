#Time Complexity: O(n) n -> number of house as colors are constant i.e 3 we donot count them
#Space Complexity: O(1) using three variables for storing cost of R,G,B respectively
#did your code run on leetcode - yes

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        #as folowing both up approach of dp we are iniatlizing the colors with cost of last house
        costR = costs[len(costs)-1][0]
        costB = costs[len(costs)-1][1]
        costG = costs[len(costs)-1][2]
        
        #we follow bottom up approach of dp
        for i in reversed(range(len(costs)-1)):
            tempR = costR
            costR = costs[i][0] + min(costB,costG)
            tempB = costB
            costB = costs[i][1] + min(tempR,costG)
            costG = costs[i][2]+ min(tempB,tempR)
        #calculate
        return min(costR,min(costB,costG))
        
