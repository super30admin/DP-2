#Time complexity: O(n) where  n is the number of houses
#Space complexity: O(1) as the colors are only 3
#Works on leetcode: yes
#Approach:Here dp is just a tuple of 3 cost values. At each house, we get minimum cost for all 3 colors which is achieved by
# adding current cost of one color and minimum of costs from other two colors from previous house. 
class Solution:
	#function to find the minimum cost to paint houses using 3 colors given no adjacent house has same colors
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        dp = costs[0]
        for i in range(1,len(costs)):
            prev = dp[:]
            for j in range(len(costs[0])):
                dp[j] = costs[i][j] + min(prev[:j]+prev[j+1:])
        return min(dp)