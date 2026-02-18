class Solution:
    def minCost(self, costs):
        m = len(costs)
        red = costs[m-1][0]
        blue = costs[m-1][1]
        green = costs[m-1][2]
        for i in range(m-2, -1, -1):
            temp_r = red
            temp_b = blue
            red = costs[i][0] + min(blue, green)
            blue = costs[i][1] + min(temp_r, green)
            green = costs[i][2] + min(temp_r, temp_b)
        return min(red, blue, green)