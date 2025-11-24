'''
For solving the House Paint problem, I considered using exahustive approach by optimizing the sub problems.
- Initially I kept the costs of last row constant, and stored in the DP matrix in the last row.
- Then by iterating in the houses and colors matrix from bottom elements to top, I calculated the sum of current element and minimum cost of either of the colors.
- After filling the DP matrix, we return the minimum of top most row elements, because by the time the elements are 
'''
class Solution:
    def minCost(self, costs):
        # no of rows/houses
        n = len(costs)
        # n houses and 3 columns
        dp = [[0] * 3 for _ in range(n)]
        # keeping the last row as it is
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]
        
        # filling the dp matrix from second last index, since the last row already has same values from costs matrix
        for i in range(n-2, -1, -1):
            # filling the elements with cost of that color with minimum of other two colors from below row
            # eg:taking the cost of painting the houses with red and cost of painting with minimum of blue/green
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        
        # minimum of top most row
        return min(dp[0][0], dp[0][1], dp[0][2])
        
'''
Time Complexity: O(n)
Here I am creating a DP matrix whose size is n*3, where 3 is constant, so we itearte on n elements which takes O(n)
Space Complexity: O(n)
Similarly for space the size of DP matrix would be n*3, where 3 is constant, so the average space taken is O(n)
'''