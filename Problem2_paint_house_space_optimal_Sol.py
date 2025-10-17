class Solution:
    #Time complexity O(n) Space is O(1) since variable stored in temp var
    def minCost(self, costs):  # 0-R, 1-B, 2-G
        n = len(costs) #rows of houses
        m = len(costs[0]) #cols of diff colors
        dp = [[0] * n for _ in range(m)]

        colorR = costs[n-1][0] #starting bottom up last red house
        colorB = costs[n-1][1] #last blue house
        colorG = costs[n-1][2] #last green house
        min(colorR, colorB, colorG)

        for i in range (n-2, -1, 1):
            tempR = colorR
            tempB = colorB
            
            colorR = costs[i][0] + min(colorB, colorG) #
            colorB = costs[i][1] + min(tempR, colorG)
            colorG = costs[i][2] + min(tempR, tempB)
        re = min(dp[0][0], dp[0][1], dp[0][2])
        return re