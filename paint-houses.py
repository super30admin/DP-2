# Time Complexity: O(3*n) -> O(n)
# Space Complexity: O(3*n) -> O(n) (Can be optimized to constant by taking index%3)
# Did it run on Leetcode: Yes
# Any problems faced: No
# Approach & Intuition

# Follow a decrease and conquer approach:
# Let's define 3 objective functions:
# green(i) -> min cost of painting 0...i houses ending with green
# blue(i) -> min cost of painting 0...i houses ending with blue
# red(i) -> min cost of painting 0...i houses ending with red
# And 3 cost functions:
# costs[i][0] - cost of painting ith house red
# costs[i][1] - cost of painting ith house blue
# costs[i][2] - cost of painting ith house green

# We can deduce the following recurrences:
# green(i) = costs[i][2] + min(blue(i-1), red(i-1)) -> If I paint my last house green, the (i-1)th house is either red or blue, to minimize the cost, consult the solutions for both and pick the min
# red(i) = costs[i][0] + min(green(i-1), blue(i-1))
# blue(i) = costs[i][1] + min(green(i-1), red(i-1))


class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if not costs:
            return 0

        red = [0 for _ in range(len(costs))]
        blue = [0 for _ in range(len(costs))]
        green = [0 for _ in range(len(costs))]

        # Base Cases
        red[0] = costs[0][0]
        blue[0] = costs[0][1]
        green[0] = costs[0][2]

        # Fill DP
        for i in range(1, len(costs)):
            red[i] = costs[i][0] + min(green[i-1], blue[i-1])
            blue[i] = costs[i][1] + min(green[i-1], red[i-1])
            green[i] = costs[i][2] + min(blue[i-1], red[i-1])

        return min(red[-1], blue[-1], green[-1])
