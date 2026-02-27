class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if not costs:
            return 0

        dp = []
        for i in range(len(costs)):
            if i == 0:
                dp.append(costs[0])
            else:
                #if i == dp.length, add a new array
                if i == len(dp):
                    dp.append([0, 0, 0])

                dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
                dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
                dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
        return min(dp[-1])

#TC : O(n)
#SC : O(n)
