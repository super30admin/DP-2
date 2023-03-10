#Time complexity: O(3*n) = O(n) - n is the number of houses and 3 is the number of colors
# Space complexity: we need a n*3 matrix to store dp array - O(n*3) = O(n)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp=[[0]*3 for i in range(len(costs))]
        for j in range(len(costs[0])):
            dp[-1][j]=costs[-1][j]
        for i in range(len(dp)-2,-1,-1):
                dp[i][0]=costs[i][0]+min(dp[i+1][1],dp[i+1][2])
                dp[i][1]=costs[i][1]+min(dp[i+1][0],dp[i+1][2])
                dp[i][2]=costs[i][2]+min(dp[i+1][0],dp[i+1][1])
        return min(dp[0])