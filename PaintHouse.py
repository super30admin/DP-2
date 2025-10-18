from typing import List


class Solution:
    # Time will be O(3.2^n) without using memo. Using memo the time improves to O(m*n) where m is total number of colors. Hence O(n)
    # Space is O(m*n) -> O(3n) -> O(n) for memo and using recursion depth stack

    # The intuition is simple, we do an exhaustive approach where we chose each and every element in the first row and the other houses in the corresponding rows without the
    # neighbors. Then select the minimum of it and finally after getting all the values, return the min cost of painting the house in the first row.
    def minCostsRecursive(self, costs: List[List:int]) -> int:

        def helper(i, j) -> int:

            if i == len(costs): return 0

            if j == 0:
                case1 = helper(i + 1, 1)
                case2 = helper(i + 1, 2)
                return costs[i][j] + min(case1, case2)
            elif j == 1:
                case1 = helper(i + 1, 0)
                case2 = helper(i + 1, 2)
                return costs[i][j] + min(case1, case2)
            else:
                case1 = helper(i + 1, 0)
                case2 = helper(i + 1, 1)
                return costs[i][j] + min(case1, case2)

        colorR = helper(0, 0)
        colorB = helper(0, 1)
        colorG = helper(0, 2)

        return min(colorR, colorB, colorG)

    # Time is O(m*n) where m in the total number of colors which is 3 in this case. Hence, O(3n) -> O(n)
    # Space is O(3*n) for dp array, hence O(n) space, which can further me optimized to O(1) space using the 3 variables shown in function minCostsUsingVariables
    # The intuition is very similar to recursive. Here we can just make using of particular row col which is already calculated to populate the value on the upper rows. Since we are
    # doing a bottom up approach.
    def minCosts(self, costs: List[List:int]) -> int:
        if not costs or not costs[0]: return 0
        n = len(costs)
        dp = [0] * 3
        for i in range(3):
            dp[i] = costs[n - 1][i]

        for i in range(n - 2, -1, -1):
            tempR = dp[0]
            dp[0] = costs[i][0] + min(dp[1], dp[2])
            tempB = dp[1]
            dp[1] = costs[i][1] + min(tempR, dp[2])
            dp[2] = costs[i][2] + min(tempR, tempB)

        return min(dp[0], dp[1], dp[2])

    def minCostsUsingVariables(self, costs: List[List:int]) -> int:
        if not costs or not costs[0]: return 0
        n = len(costs)
        costR = costs[n-1][0]
        costB = costs[n-1][1]
        costG = costs[n-1][2]
        for i in range(n - 2, -1, -1):
            tempR = costR
            costR = costs[i][0] + min(costB, costG)
            tempB = costB
            costB = costs[i][1] + min(tempR,costG)
            costG = costs[i][2] + min(tempR, tempB)

        return min(costR, costB, costG)
