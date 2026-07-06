class Solution:
    def minCost(self, costs):
        m = len(costs)
        n = len(costs[0])

        colorR = costs[m-1][0]
        colorB = costs[m-1][1]
        colorG = costs[m-1][2]

        for i in range(m-2, -1, -1):
            tempR = colorR
            tempB = colorB

            colorR = costs[i][0] + min(colorB, colorG)
            colorB = costs[i][1] + min(tempR, colorG)
            colorG = costs[i][2] + min(tempR, tempB)

        return min(colorR, colorB, colorG)


    # TC - O(n)
    # SC - O(1) because 2 pointers approach, if we use DP it will be O(n)