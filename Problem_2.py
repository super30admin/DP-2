# 256. Paint House

# code:

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # Base case
        if not costs:
            return 0
        
        # Take the min from the above house and move on!
        for i in range(1,len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][0], costs[i-1][1])
        
        # Return the min from the last house
        
        return min(costs[-1][0], min(costs[-1][1], costs[-1][2]))

# Time Complexity: O(N * M) --> M = 3 --> O(N * 3) --> O(N)
# Space Complexity: O(1)
# Accepted on Leetcode: Yes.
# Any Difficulty faced. No.