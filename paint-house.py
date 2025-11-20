# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : yes was able to solve the question
# Any problem you faced while coding this : No

class Solution:
    # This solution takes the DP route, here we first check for the base case if the house is present to paint.
    # second we put the minmum cost as -inf but this can be -1 as cost cannot be in -ve.
    # third we iterate through the paint or color. 
    # fourth we check if the current color is same as the previous color as we recursively pass the previously used color.
    # fifth we will make the dp call with the next house and provide the prev color and also add the current color of current house.
    # here we also take the minimum of the cost
    # in end we send the min cost.
    # the time complexity for this will be: O(n)
    # the space complexity for this function will be: O(n)
    def minCost(self, costs):
        def dp(i, prev):
            # base case
            if i >= len(costs):
                return 0
            min_cost = float('inf')
            for c in range(3):
                if prev != c:
                    min_cost = min(min_cost, dp(i + 1, c) + costs[i][c])
            return min_cost
        return dp(0, -1)
    
    # here we use the same costs matrices to compute the minimum cost for the houses to be painted
    # Time complexity will be O(n)
    # Space complexity will be O(1)
    def minCost(self, costs):
        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][1], costs[i-1][1])
        return min(costs[-1])

s = Solution()
costs = [[17,2,17],[16,16,5],[14,3,19]]
print(s.minCost(costs))
costs = [[7,6,2]]
print(s.minCost(costs))
        