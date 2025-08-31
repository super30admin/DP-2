from typing import (
    List,
)

class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    
    Time Complexity: O(n)  
        - We iterate once over the n houses, and for each house we compute 3 values (constant work).
    
    Space Complexity: O(n)  
        - We use a dp table of size n x 3. 
        - This can be optimized to O(1) since at any step we only need the next row.
    """
    def min_cost(self, costs: List[List[int]]) -> int:
        # write your code here

        n = len(costs)
        if not costs:
            return 0

        dp = [[0 for _ in range(3)] for _ in range(n)]

        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]

        for i in range(n-2, -1, -1): 
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][0])
        return min(dp[0][0], dp[0][1], dp[0][2])

