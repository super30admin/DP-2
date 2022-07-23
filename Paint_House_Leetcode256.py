class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # SC - O(1) DP without extra space
        # TC - O(n)
        n = len(costs)
        colorR = costs[n - 1][0]
        colorB = costs[n - 1][1]
        colorG = costs[n - 1][2]

        for i in range(n - 2, -1, -1):
            TempR = colorR
            TempB = colorB
            colorR = costs[i][0] + min(colorB, colorG)
            colorB = costs[i][1] + min(TempR, colorG)
            colorG = costs[i][2] + min(TempR, TempB)

        return min(colorR, colorB, colorG)

    '''
        # DP without altering costs thereby using SC = O(3*n) = O(n)
        # TC - O(n)

        n = len(costs)
        dp = [[0]*3 for _ in range(n)]
        dp[n-1] = costs[n-1] #intialize last row of dp same as costs last row

        for i in range(n-2,-1,-1):
            dp[i][0] =costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] =costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] =costs[i][2] + min(dp[i+1][0], dp[i+1][1])

        return min(dp[0][0],dp[0][1],dp[0][2])
    '''

    '''
        # DP using the same costs matrix
        # TC - O(n)
        # SC - O(1)

        n = len(costs)
        for i in range(n-2,-1,-1):
            costs[i][0] =costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] =costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] =costs[i][2] + min(costs[i+1][0], costs[i+1][1])

        return min(costs[0][0],costs[0][1],costs[0][2])
    '''
    '''
        # Recursion Time Limit exceeded
        # TC O(3*(2**n))
        # SC O(n)
        color_0 = self.helper(costs, 0 , 0, 0)
        color_1 = self.helper(costs, 0 , 1, 0)
        color_2 = self.helper(costs, 0 , 2, 0)

        return min(color_0, color_1,color_2)

    def helper(self, costs, i , color, mincost):
        #base
        if i == len(costs):
            return mincost

        #logic
        if color == 0:
            return min(self.helper(costs, i+1 , 1, mincost + costs[i][0]), self.helper(costs, i+1,2, mincost + costs[i][0]))

        elif color == 1:
            return min(self.helper(costs, i+1, 2, mincost + costs[i][1]), self.helper(costs, i+1 , 0, mincost + costs[i][1]))

        elif color == 2:
            return min(self.helper(costs, i+1 , 1, mincost + costs[i][2]),self.helper(costs, i+1 ,0, mincost + costs[i][2]))
    '''
