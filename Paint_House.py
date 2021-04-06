class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        dp = costs[0]
        
        for i in range(1, len(costs)):
            new_dp = [None]*3
            new_dp[0] = costs[i][0] + min(dp[1], dp[2])
            new_dp[1] = costs[i][1] + min(dp[0], dp[2])            
            new_dp[2] = costs[i][2] + min(dp[0], dp[1])            
            dp = new_dp
        
        return min(dp)

### Complexity Analysis:

# Time Compelxity: O(N) --> Iterating through the costs array only once
# Space Complexity: O(1) --> Dp array used is of fixed dimension irrespective of input size.