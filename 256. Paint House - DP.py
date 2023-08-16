# Time and space complexity = O(N)
class Solution:
    # Define a method minCost which takes a 2D list 'costs' as input and returns an integer
    def minCost(self, costs: List[List[int]]) -> int:
        # Get the number of rows in the 'costs' matrix
        n = len(costs)
        
        # Create a dynamic programming (DP) matrix 'dp' with n rows and 3 columns, initialized with 0s
        dp = [[0 for _ in range(3)] for _ in range(n)]
        
        # Initialize the last row of the DP matrix with the costs from the input matrix
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]
        
        # Iterate through the rows of the DP matrix in reverse order (from n-2 to 0)
        for i in range(n-2, -1, -1):
            # Calculate the minimum cost for painting the current house with color 0
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            # Calculate the minimum cost for painting the current house with color 1
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            # Calculate the minimum cost for painting the current house with color 2
            dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][0])
        
        # Return the minimum cost among the three possible colors for painting the first house (at index 0)        
        return min(dp[0][0], dp[0][1], dp[0][2])
