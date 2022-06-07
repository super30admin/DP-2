class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        dp = [0,0,0]
        
        for i in range(len(costs)):
            dp_0 = costs[i][0] + min(dp[1], dp[2])
            dp_1 = costs[i][1] + min(dp[0], dp[2])
            dp_2 = costs[i][2] + min(dp[0], dp[1])
            dp = [dp_0,dp_1, dp_2]
            
        return min(dp)
            
        # space : o(1)
        # time : o(n)