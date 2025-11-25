# Initialize a 2x2 array with rows of the number of houses and columns with the number of colors.
# For each house/row, assign the value of each color as a summation of its current value and the minimum 
# of the other 2 colors. Return the the min of last row

# Time complexity: O(n)
# Space complexity: O(n)

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        # edge case
        if not costs:
            return 0
             
        dp= [row[:] for row in costs]
        rows = len(costs)
        cols = len(costs[0])
        

        print(dp)
        for i in range(1,rows):
            dp[i][0]=dp[i][0]+min(dp[i-1][1],dp[i-1][2])
            dp[i][1]=dp[i][1]+min(dp[i-1][0],dp[i-1][2])
            dp[i][2]=dp[i][2]+min(dp[i-1][1],dp[i-1][0])
        
        return min(dp[rows-1])
costs = [
    [17, 2, 17],
    [16, 16, 5],
    [14, 3, 19]
]

sol = Solution()
print(sol.minCost(costs))
        # dp initialization (first house same as cost)
        
        # iterate through houses
        
        # return final minimum
