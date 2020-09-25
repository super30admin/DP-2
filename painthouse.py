class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def minCost(self, costs):
        # write your code here
        dp = costs
        if len(costs) == 0 or len(costs[0]) == 0 :
            return 0
        for i in range(1,len(costs)):
            dp[i][0] += min(dp[i-1][1],dp[i-1][2]) 
            dp[i][1] += min(dp[i-1][0],dp[i-1][2])
            dp[i][2] += min(dp[i-1][0],dp[i-1][1])
        return min(dp[-1][0],dp[-1][1],dp[-1][2])

# time complecity O(nc)n->number of houses and c is number of colors(as it is contstant ) -> O(n)
# time complexity is Again O(nc) -> O(n) which can be taken to O(1) by changinf the costs it self