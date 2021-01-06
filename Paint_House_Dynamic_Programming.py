# Created by Aashish Adhikari at 1:07 PM 1/6/2021

'''
Time Complexity:
O (No of houses)

Space Complexity:
O(1)

'''

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) == 0:
            return 0

        for idx in range(1, len(costs)):

            costs[idx][0] += min(costs[idx-1][1], costs[idx-1][2])
            costs[idx][1] += min(costs[idx-1][0], costs[idx-1][2])
            costs[idx][2] += min(costs[idx-1][1], costs[idx-1][0])

        return min(costs[-1][0], costs[-1][1], costs[-1][2])
