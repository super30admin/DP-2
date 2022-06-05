# time complexity: O(n)
# space complexity: O(n)

class Solution:
    def minCost(self, costs) -> int:
        if(costs == None or len(costs) == 0): 
            return 0;

        n = len(costs)
        colorR = costs[n-1][0]
        colorB = costs[n-1][1]
        colorG = costs[n-1][2]
        for i in range(n-2, -1, -1): 
            tempR = colorR
            tempB = colorB
            colorR = costs[i][0] + min(colorB, colorG)
            colorB = costs[i][1] + min(tempR, colorG)
            colorG = costs[i][2] + min(tempR, tempB)

        return min(colorR, colorB, colorG)
    
obj = Solution()
print(obj.minCost([[17,2,17],[16,16,5],[14,3,19]]))
        