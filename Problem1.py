'''
The problem is same as house robber. We just have 3 choices to make.
Time complexity: O(n)
Space complexity: O(1)
'''

class Solution:
    def paint(self, costs: List[int][int]) -> int:
        dp = [math.inf, math.inf, math.inf]

        for cost in costs:
            chooseRed = cost[0] + min(dp[2], dp[1])
            chooseGreen = cost[1] + min(dp[0], dp[2])
            chooseBlue = cost[2] + min(dp[0], dp[1])

            dp = [chooseRed, chooseGreen, chooseBlue]

        return max(dp)