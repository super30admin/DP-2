# Runs on Leetcode
    # Runtime - O(n)
    # Memory - O(n) where n is length of costs


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        dp = costs[0]
        for i in range(1, len(costs)):
            pre = dp[:]
            dp[0] = costs[i][0] + min(pre[1], pre[2])
            dp[1] = costs[i][1] + min(pre[0], pre[2])
            dp[2] = costs[i][2] + min(pre[0], pre[1])
        return min(dp)
