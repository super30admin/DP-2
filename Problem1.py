#Problem 2 : https://leetcode.com/problems/paint-house/
#Test Cases Passed on LeetCode
#Time Complexity-O(N*3)=O(N) where N is the no of house and 3 -no of colors
#Space Complexity-O(N*3)=O(N) where N is the no of house and 3 -no of colors

class Solution:
    def minCost(self, costs):
        #declare a 2 array 
        if not costs:
            return 0
        dp=[[0 for col in range(3)] for row in range(len(costs))]
        #base case
        dp[0]=costs[0]
        for i in range(1,len(costs)):
            #if red is selected
            dp[i][0]=costs[i][0]+min(dp[i-1][1],dp[i-1][2])
            
            #if green is selected
            dp[i][1]=costs[i][1]+min(dp[i-1][0],dp[i-1][2])
            
             #if blue is selected
            dp[i][2]=costs[i][2]+min(dp[i-1][0],dp[i-1][1]) 
        print(dp)
        return min(dp[-1])

sol=Solution()
costs=[[17,2,17],[16,16,5],[14,3,19]]
print(sol.minCost(costs))













