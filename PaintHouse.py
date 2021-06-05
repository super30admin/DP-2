class Solution:
    def minCost(self, costs) -> int:
        if not costs:
            return 0
        maxlength = len(costs)
        red = costs[maxlength-1][0]
        blue = costs[maxlength-1][1]
        green = costs[maxlength-1][2]
        for i in range(len(costs)-2, -1, -1):
            prevred = red
            prevblue = blue
            red = costs[i][0]+min(blue, green)
            blue = costs[i][1]+min(prevred, green)
            green = costs[i][2]+min(prevred, prevblue)
        return min(red, min(blue, green))


        # for i in range(len(costs)-2, -1, -1):
        #     costs[i][0]+=min(costs[i+1][1], costs[i+1][2])
        #     costs[i][1]+=min(costs[i+1][0], costs[i+1][2])
        #     costs[i][2]+=min(costs[i+1][0], costs[i+1][1])
        # return min(costs[0][0], min(costs[0][1], costs[0][2]))

    #     if not costs:
    #         return 0
    #     caseR = self.helper(costs, 0, 0, 0)
    #     caseB = self.helper(costs, 0, 1, 0)
    #     caseG = self.helper(costs, 0, 2, 0)
    #     return min(caseR, min(caseB, caseG))      
    
    # def helper(self, costs, row, color, optimalCost):
    #     if row == len(costs):
    #         return optimalCost
        
    #     if color == 0:
    #         return min(self.helper(costs, row+1, 1, optimalCost+costs[row][0]), self.helper(costs, row+1, 2, optimalCost+costs[row][0]))
    #     if color == 1:
    #         return min(self.helper(costs, row+1, 0, optimalCost+costs[row][1]), self.helper(costs, row+1, 2, optimalCost+costs[row][1]))
    #     if color == 2:
    #         return min(self.helper(costs, row+1, 0, optimalCost+costs[row][2]), self.helper(costs, row+1, 1, optimalCost+costs[row][2]))
    #     return 9999999

sol = Solution()
print(sol.minCost([[17,2,11],[16,5,20],[14,13,19]]))

"""Time complexity - O(n)
space complexity - O(1) as we are using 2 variables to store the previous values

If array is used to implement it, then the space complexity would be O(n) where n is number of houses
and the number of colors are constant"""