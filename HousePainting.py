class HousePainting(object):
    '''
    Solution:
    1. A recursion problem where overlapping subproblems exist and so use Dynamic Programming.
    2. Update the given cost matrix by updating the current row's cell with minimum of previous row's columns (not the
        same column).
    3. Return the minimum value obtained in the last row.

    --- Handled all edge cases and so it should pass all Leetcode testcases
    '''

    def minCost(self, costs):

        # O(n) Time Complexity | zero space
        if (costs == None or len(costs) <= 0):
            return -1

        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
            costs[i][2] += min(costs[i - 1][1], costs[i - 1][0])

        return min(costs[len(costs) - 1][0], min(costs[len(costs) - 1][1], costs[len(costs) - 1][2]))