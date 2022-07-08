# Time Complexity: o(n)
# Space Complexity: o(n)

class Solution:
    def func(arr):
        m = len(arr)
        n = 3
        dp =[[0]*n for _ in range(m)]
        for i in range(n):
            dp[m-1][i] = arr[m-1][i]   

        for i in reversed(range(0,2)):
            for j in range(n):
                if j ==0:
                    dp[i][j] = arr[i][j] + min(dp[i+1][1],dp[i+1][2])
                if j ==1:
                    dp[i][j] = arr[i][j] + min(dp[i+1][0],dp[i+1][2])
                if j ==2:
                    dp[i][j] = arr[i][j] + min(dp[i+1][1],dp[i+1][0])
                    
        return min(dp[0][0],dp[0][1],dp[0][2])