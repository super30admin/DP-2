
# DP SOLUTION

# Time Complexity: O(M*N), M: no.of.rows, N: no.of. columns
# Space Complexity: O(M*N) for dp matrix
# Did problem run on Leetcode: yes

class Solution:
    def minCost(self, costs):

        # EDGE CASE
        if not costs:
            return 0
        
        # LOGIC
        dp = [[0 for i in range(len(costs[0]))] for j in range(len(costs))]
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

        for i in range(1, len(costs)):
            dp[i][0] = min(dp[i-1][1], dp[i-1][2])+ costs[i][0]
            dp[i][1] = min(dp[i-1][0], dp[i-1][2])+ costs[i][1]
            dp[i][2] = min(dp[i-1][0], dp[i-1][1])+ costs[i][2]

        m = len(costs)
        return min( dp[m-1][0], dp[m-1][1], dp[m-1][2])

obj = Solution()
print(obj.minCost(costs=[[17,2,17],[16,16,5],[14,3,19]]))

