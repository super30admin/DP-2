
#Time complexity: O(N)
#Space complexity:O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs==None or len(costs)==0:
            return 0
        
        n=len(costs)
        red=costs[n-1][0]
        blue=costs[n-1][1]
        green=costs[n-1][2]

        for i in range(n-2,-1,-1):
            tempRed=red
            tempBlue=blue
            red=costs[i][0]+min(blue,green)
            blue=costs[i][1]+min(tempRed,green)
            green=costs[i][2]+min(tempRed,tempBlue)
        
        return min(red,blue,green)

        