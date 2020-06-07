# All analysis is for the solution on line 55 and beyond.
# Time Complexity : O(n), where n is the length of costs array.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Ran on PyCharm
# Any problem you faced while coding this : No.

# Your code here along with comments explaining your approach
class Solution(object):
    # approach 1 Brute Force/greedy, Time limit exceeded
    def paintGreedy(self, costs):
        if not costs: return 0
        case1 = self.helper(costs, 0, 0, 0)
        case2 = self.helper(costs, 0, 0, 1)
        case3 = self.helper(costs, 0, 0, 2)
        return min(case1, case2, case3)

    def helper(self, costs, arrIndex, cost, lastColor):
        # base case
        if arrIndex == len(costs): return cost
        # logic
        case1, case2, case3 = float('inf'), float('inf'), float('inf')
        if lastColor == 0:
            case1 = min(
                # next house, choose color 1
                self.helper(costs, arrIndex+1, cost+costs[arrIndex][1], 1),
                # next house, choose color 2
                self.helper(costs, arrIndex+1, cost+costs[arrIndex][2], 2))
        elif lastColor == 1:
            case2 = min(
                # next house, choose color 0
                self.helper(costs, arrIndex+1, cost+costs[arrIndex][0], 0),
                # next house, choose color 2
                self.helper(costs, arrIndex+1, cost+costs[arrIndex][2], 2))
        else:
            case3 = min(
                # next house, choose color 0
                self.helper(costs, arrIndex+1, cost+costs[arrIndex][0], 0),
                # next house, choose color 1
                self.helper(costs, arrIndex+1, cost+costs[arrIndex][1], 1))

        return min(case1, case2, case3)

    # approach 2, using a 2 dimensional array
    def paint2DArray(self, costs):
        if not costs: return 0
        dpArray = [[0 for _ in range(len(costs[0]))] for _ in range(len(costs))]
        dpArray[0] = costs[0]

        for i in range(1, len(dpArray)):
            dpArray[i][0] = costs[i][0] + min(dpArray[i-1][1], dpArray[i-1][2])
            dpArray[i][1] = costs[i][1] + min(dpArray[i-1][0], dpArray[i-1][2])
            dpArray[i][2] = costs[i][2] + min(dpArray[i-1][0], dpArray[i-1][1])
        return min(dpArray[-1])

    # approach 3, reusing input array.
    #
    # Reusing the input array is possible because we are making
    # a summation of all previous values to find the minimum.
    # for every color, select the minimum from the cost of the
    # other 2 colors and make a summation at each level.
    # return the minimum from the last level.
    def paintNoExtraSpace(self, costs):
        if not costs: return 0

        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][0], costs[i-1][1])
        return min(costs[-1])


costs = [[17,2,17],[16,16,5],[14,3,19],[62,35,10]]
# output: 20
s = Solution()
print s.paintNoExtraSpace(costs)

