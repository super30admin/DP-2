#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
# Solve the subproblem gradually and store these intermediate results. If considering to paint a 
#house red, check whether from the previosu row(solution for subproblem) whether to selct blue or 
#green. Similarly perform the same opeartion for green and blue ie, for row i and to paint red color, 
#pcik minimum of green or blue from i-1th row.

class Solution:
    def minCost(self, costs) -> int:
        dp=[]
        for i in costs:
            dp.append([-1,-1,-1])
        n=len(costs)
        dp[n-1][0]=costs[n-1][0]
        dp[n-1][1]=costs[n-1][1]
        dp[n-1][2]=costs[n-1][2]
        #print(dp)
        i=n-2
        while(i>=0):
            dp[i][0]=min(costs[i][0]+dp[i+1][1],costs[i][0]+dp[i+1][2])
            dp[i][1]=min(costs[i][1]+dp[i+1][0],costs[i][1]+dp[i+1][2])
            dp[i][2]=min(costs[i][2]+dp[i+1][0],costs[i][2]+dp[i+1][1])
            i-=1
        return min(dp[0][0],dp[0][1],dp[0][2])
s=Solution()
costs = [[17,2,17],[16,16,5],[14,3,19]]
print(s.minCost(costs))
