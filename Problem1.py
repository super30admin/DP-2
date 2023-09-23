'''
1. Take the last but one row as a starting point. For each color, check which one from other 2 gives minimum cost and add it. The minimum cost will be the minimum of the top row.
TC: O(n) SC: O(n)
2. If we shouldn't modify the array in place, take three temporary variables keeping a track of the latest sum obtained from the next row (bottom to top) and add the current color's cost to the min.
3. We will have the minimum cost as the lowest of the three variables we are computing.
TC: O(n) SC: O(1)
'''



class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) ==0:
            return 0

    #In place        
        # for i in range(len(costs)-2,-1,-1):
        #     costs[i][0] += min(costs[i+1][1],costs[i+1][2])
        #     costs[i][1] += min(costs[i+1][0],costs[i+1][2])
        #     costs[i][2] += min(costs[i+1][0],costs[i+1][1])
        # return min(costs[0])

    # Do not modify array
        n = len(costs)
        redcolor, bluecolor, greencolor = costs[n-1][0], costs[n-1][1], costs[n-1][2]

        for i in range(n-2,-1,-1):
            tempred, tempblue,tempgreen = redcolor,bluecolor, greencolor
            redcolor = min(tempblue,tempgreen) + costs[i][0]
            bluecolor = min(tempred,tempgreen) + costs[i][1]
            greencolor = min(tempred,tempblue) + costs[i][2]
        return min(redcolor,bluecolor,greencolor)