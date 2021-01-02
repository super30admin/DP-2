# Time Complexity : O(N)
# Space Complexity : O(N*3) basically size of costs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Tried figuring out brute force 
# and the recursive tree. Good problem


# Your code here along with comments explaining your approach
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        """ 
        Would greedy be taking the min in each house? But won't work because what if min happens to be 
        same color in the next house.

        DP approach would be taking the current row with the min's previous row that is NOT in the same column otherwise
        there would be the same color.
        """
        if not costs:
            return 0
        dp = [[0 for j in range(len(costs[0]))] for i in range(len(costs))]
        
        dp[0] = costs[0]
        
        for i in range(1, len(costs)):
            dp[i][0] = costs[i][0] + min(dp[i-1][1:3])
            dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][:2])
        
        return min(dp[len(costs) - 1][0], min(dp[len(costs) - 1][1], dp[len(costs) - 1][2])) 

