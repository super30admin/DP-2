class Solution:
    
    def min_cost(self, costs: List[List[int]]) -> int:


        def min_cost(self, costs: List[List[int]]) -> int:

        #here we optimize the below solution by taking 3 valriable for 3 colors
        #Time complexity - O(3*no. of houses)
        #Space complexity - O(1)
        if not costs:
            return 0
        # write your code here
        rows = len(costs)
        cols = len(costs[0])

        red = costs[0][0]
        blue = costs[0][1]
        green = costs[0][2]
        print(red, blue, green)

        for i in range(1, rows):
            tempR = red
            tempB = blue
            red = min(costs[i][0]+blue, costs[i][0]+green)
            blue = min(costs[i][1]+tempR, costs[i][1]+green)
            green = min(costs[i][2]+tempR, costs[i][2]+tempB)
            print(red, blue, green)
        return min(red, blue, green)


        #-----------------------OR-------------------------------------------

        #Here we start from top/bottom row taking same as in costs array. Then we calculate further rows.
        #To compute current cell we take minimum of current cell cost+previous cell cost with different color.
        #At the end we take the minimum among cells of final row of traversal.
        #Time complexity - O(rows*cols) i.e. (number of houses * number of colors)
        #Space complexity - O(rows*cols) i.e. (number of houses * number of colors)
        if not costs:
            return 0
        # write your code here
        rows = len(costs)
        cols = len(costs[0])

        dp = [[0]*cols for i in range(rows)]

        for i in range(rows):
            for j in range(cols):
                if i==0:
                    dp[i][j] = costs[i][j]
                else:
                    if j==0:
                        dp[i][j] = min(costs[i][j]+dp[i-1][1], costs[i][j]+dp[i-1][2])

                    elif j==1:
                        dp[i][j] = min(costs[i][j]+dp[i-1][0], costs[i][j]+dp[i-1][2])


                    else:
                        dp[i][j] = min(costs[i][j]+dp[i-1][0], costs[i][j]+dp[i-1][1])

        return min(dp[rows-1][::])



        #-----------------------OR-------------------------------------------

        #Using exhaustive approach
        #Time and space complexity - O(3*2^n) where n = no. of houses
        def min_cost(self, costs: List[List[int]]) -> int:
            if not costs:
                return 0
            red = self.helper(costs, 0, 0, 0)
            blue = self.helper(costs, 0, 1, 0)
            green = self.helper(costs, 0, 2, 0)

            return min(red, blue, green)
        
        def helper(self, costs, amt, color, hIdx):
            if hIdx>=len(costs):
                return amt

            if color==0:
                return min(self.helper(costs, amt+costs[hIdx][0], 1, hIdx+1),
                self.helper(costs, amt+costs[hIdx][0], 2, hIdx+1))

            if color==1:
                return min(self.helper(costs, amt+costs[hIdx][1], 0, hIdx+1),
                self.helper(costs, amt+costs[hIdx][1], 2, hIdx+1))

            if color==2:
                return min(self.helper(costs, amt+costs[hIdx][2], 0, hIdx+1),
                self.helper(costs, amt+costs[hIdx][2], 1, hIdx+1))


