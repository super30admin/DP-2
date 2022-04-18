# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) == 0:
            return 0
        previous_row = costs[0]

        for i in range(1, len(costs)):
            current_row = costs[i]

            current_row[0] = current_row[0] + \
                min(previous_row[1], previous_row[2])

            current_row[1] = current_row[1] + \
                min(previous_row[0], previous_row[2])

            current_row[2] = current_row[2] + \
                min(previous_row[0], previous_row[1])

            previous_row = current_row

        return min(previous_row)
