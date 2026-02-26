#Paint House

#Time complexity = O(n*3) so basically On
#Space complexity O1
#for each new house check the minimium to cost with each of the colors, by choosing the minimum possible till previous house from the remaining colors

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        red = costs[0][0]
        blue = costs[0][1]
        green = costs[0][2]

        for i in range(1, len(costs)):
            oldRed = red
            red = costs[i][0] + min(blue, green)

            oldBlue = blue
            blue = costs[i][1] + min(oldRed, green)

            green = costs[i][2] + min(oldRed, oldBlue)

        return min(red,min(green,blue))