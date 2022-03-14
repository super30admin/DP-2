# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Once you choose a color for a house, you are left with two choices for the adjacent houses. We choose the minimum from
# those two choices. For the next house, you choose the minimum from the two colors other than the one which was used in the 
# house just previous to it.
# We created a dp array of length 3 i.e len(costs[i]). These 3 values will maintain the minimum cost of colors for all 3 paths that we can
# take to paint the house. The minimum of these paths will be the answer we're looking for.


from collections import defaultdict
from typing import List

class Solution:
    def min_cost(self, costs: List[List[int]]) -> int:
        dp=[0,0,0]

        for i in range(len(costs)):
            dp0=costs[i][0] + min(dp[1],dp[2])
            dp1=costs[i][1] + min(dp[0],dp[2])
            dp2=costs[i][2] + min(dp[0],dp[1])

            dp=[dp0,dp1,dp2]
        return min(dp)

        # def min_cost(self, costs: List[List[int]]) -> int:
        
    #     resMap=defaultdict(int)
    #     resMap[0]=costs[0].index(min(costs[0]))
    #     resLen=min(costs[0])

    #     for i in range(1,len(costs)):
    #         currLen=float('inf')
    #         for j in range(len(costs[i])):
    #             if resMap[i-1]!=j:
    #                 currLen=min(currLen,costs[i][j])
    #                 if currLen==costs[i][j]:
    #                     resMap[i]=j
    #         resLen+=currLen
    #     return resLen        

obj=Solution()
print(obj.min_cost([[14,2,11],[11,14,5],[14,3,10]]))