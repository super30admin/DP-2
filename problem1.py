'''
Time Complexity :O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a function and traverse recursively every time we see a red do cases for blue and green recurisvely,
every time we see a blue we do red and green and everytime we see a green do red and blue.
Used memoisation pattern to remember if we saw a color at a particular index, if we do see it return it from the dictionary
else calculate it
'''


class Solution:
    def __init__(self):
        self.mem = {}

    def helper(self, costs: List[List[int]], depth, index) -> int:

        if len(costs) == 0 or costs == None:
            return 0

        if (depth, index) in self.mem.keys():
            return self.mem[(depth, index)]

        totalSum = costs[depth][index]

        if depth != len(costs) - 1:

            if index == 0:
                totalSum = totalSum + min(self.helper(costs, depth + 1, 1), self.helper(costs, depth + 1, 2))
            elif index == 1:
                totalSum = totalSum + min(self.helper(costs, depth + 1, 0), self.helper(costs, depth + 1, 2))
            elif index == 2:
                totalSum = totalSum + min(self.helper(costs, depth + 1, 0), self.helper(costs, depth + 1, 1))

        self.mem[(depth, index)] = totalSum

        return totalSum

    def minCost(self, costs: List[List[int]]) -> int:
        case1 = self.helper(costs, 0, 0)
        case2 = self.helper(costs, 0, 1)
        case3 = self.helper(costs, 0, 2)

        return min(case1, case2, case3)