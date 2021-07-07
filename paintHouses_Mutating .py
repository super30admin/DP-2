
# MUTATING THE GIVEN MATRIX

# Time Complexity: O(M*N), M: no.of.rows, N: no.of. columns
# Space Complexity: O(1), No extra Data Structure used
# Did problem run on Leetcode: yes

class Solution:
    def minCost(self, costs):

        # EDGE CASE
        if not costs:
            return 0
        
        # LOGIC
        for i in range(1, len(costs)):
            costs[i][0] = min(costs[i-1][1], costs[i-1][2])+ costs[i][0]
            costs[i][1] = min(costs[i-1][0], costs[i-1][2])+ costs[i][1]
            costs[i][2] = min(costs[i-1][0], costs[i-1][1])+ costs[i][2]

        m = len(costs)
        return min( costs[m-1][0], costs[m-1][1], costs[m-1][2])

obj = Solution()
print(obj.minCost(costs=[[17,2,17],[16,16,5],[14,3,19]]))

