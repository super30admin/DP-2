# Approach: Dynamic programming
# The apporach to this problem would be something like this. 
# In matrix we will update first value each row to (value + minimum of the 2 paint prices from previous houses (respecting the ajacent house condition).
# That means minimum value in last row will contain the minimum sum.


# Time Complexity: O(m*n) where m = no of rows, n = no of columns
# Space Complexity: O(1)

class Solution:
	def minCost(self, costs):
		if costs == None or len(costs) == 0:
			return 0

		n = len(costs)

		for i in range(1, n):
			costs[i][0] += min(cost[i-1][1], cost[i-1][2])
			costs[i][1] += min(cost[i-1][0], cost[i-1][2])
			costs[i][2] += min(cost[i-1][0], cost[i-1][1])

		return min(A[-1])