#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        dp = costs[-1]
        
        for i in range(len(costs)-2,-1,-1):
            tempr = dp[0]
            tempb = dp[1]
            tempg = dp[2]
            
            for j in range(0,3):
                if j==0:
                    dp[j] = costs[i][j] + min(tempb,tempg)
                elif j==1:
                    dp[j] = costs[i][j] + min(tempr,tempg)
                else:
                    dp[j] = costs[i][j] + min(tempb,tempr)

        return min(dp)
        