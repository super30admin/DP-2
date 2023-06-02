# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
  def minCost(self, costs):
    for i in range(1, len(costs)):
      costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
      costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
      costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])
    return min(costs[-1])