# Created by Aashish Adhikari at 12:58 PM 1/6/2021

'''
Time Complexity:
O (3 ^ No of houses)

Space Complexity:
O(1) since constant auxiliary space is being used.


'''

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """

        if len(costs) == 0:
            return 0

        level = 0

        case1 = self.helper(costs, level+1, 0, costs[level][0])
        case2 = self.helper(costs, level+1, 1, costs[level][1])
        case3 = self.helper(costs, level+1, 2, costs[level][2])

        return min(case1, case2, case3)

    def helper(self, costs, level, last_index, total):

        # base case of recursion
        if level == len(costs):
            return total

        if last_index == 0:

            return min( self.helper(costs, level+1, 1, costs[level][1] + total), self.helper(costs, level+1, 2, costs[level][2] + total))
        elif last_index == 1:

            return min( self.helper(costs, level+1, 0, costs[level][0] + total), self.helper(costs, level+1, 2, costs[level][2] + total))
        else:

            return min( self.helper(costs, level+1, 1, costs[level][1] + total), self.helper(costs, level+1, 0, costs[level][0] + total))

