# Problem 1: Coin Change II
# Time Complexity : O(N*M)
# Space Complexity : O(M)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[0]*(amount+1)
        dp[0]=1
        dl=len(dp)

        for i in coins:
            for j in range(dl):
                if j-i>=0:
                    dp[j]=dp[j]+dp[j-i]
        
        return dp[-1]



# Problem 2: House Painting
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def solve(self, costs):
        dp=costs[0]
        dl=len(costs)
        if dl>1:
            for i in range(1,len(costs)):
                tR, tB, tG=dp
                dp[0]=costs[i][0]+min(tB,tG)
                dp[1]=costs[i][1]+min(tR,tG)
                dp[2]=costs[i][2]+min(tR,tB)
        
        return min(dp)