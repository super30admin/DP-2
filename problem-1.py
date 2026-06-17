# LEETCODE PROBLEM PAINT HOUSE
# TIME COMPLEXITY:O(N) where N is the array length for the given number of colors present
# SPACE COMPLEXITY: O(1)
# Any problem you faced while coding this: None


class Solution:
    def minCost(self,costs):

        #Approach 1
        # m=len(costs)
        # n=len(costs[0])

        # dp=[[0]*n for _ in range(m)]

        # dp[0][0]=costs[0][0]
        # dp[0][1]=costs[0][1]
        # dp[0][2]=costs[0][2]

        # for i in range(1,m):
        #     dp[i][0]=costs[i][0]+min(dp[i-1][1],dp[i-1][2])
        #     dp[i][1]=costs[i][1]+min(dp[i-1][0],dp[i-1][2])
        #     dp[i][2]=costs[i][2]+min(dp[i-1][0],dp[i-1][1])

        # return min(dp[m-1][0],dp[m-1][1],dp[m-1][2])

        #Approach 2
        m=len(costs)
        n=costs[0]
        colorRed=costs[0][0]
        colorBlue=costs[0][1]
        colorGreen=costs[0][2]

        for i in range(1,m):
            tempRed=colorRed
            tempBlue=colorBlue

            colorRed=costs[i][0]+min(colorBlue,colorGreen)
            colorBlue=costs[i][1]+min(tempRed,colorGreen)
            colorGreen=costs[i][2]+min(tempRed,tempBlue)

        return min(colorRed,colorBlue,colorGreen)
    
costs=[[17,2,17],[16,16,5],[14,3,19]]
sol=Solution()
print(sol.minCost(costs))