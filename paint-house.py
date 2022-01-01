# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        n = len(costs)

        for i in range(1, n):  # 1 to n is because we wouldnt be considering the last row

            # as we cannot colour the adjacent house we will chose the other two other than the selected one
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][1], costs[i-1][0])

        return min(costs[n-1][0], min(costs[n-1][1], costs[n-1][2]))
