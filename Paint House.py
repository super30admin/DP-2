class Solution:
    # @param A : list of list of integers
    # @return an integer
    def solve(self, A):
        n = len(A)
        dp = [[0 for j in range(3)] for i in range(n)]
        
        for i in range(3):
            dp[n-1][i] = A[n-1][i]
        
        for i in range(n-2,-1,-1):
            for j in range(3):
                dp[i][0] = A[i][0]+min(dp[i+1][1],dp[i+1][2])
                dp[i][1] = A[i][1]+min(dp[i+1][0],dp[i+1][2])
                dp[i][2] = A[i][2]+min(dp[i+1][1],dp[i+1][0])
        
        return min(dp[0][0],min(dp[0][1],dp[0][2]))