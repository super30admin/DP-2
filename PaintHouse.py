# Problem1(https://leetcode.com/problems/paint-house/)

class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs: List[List[int]]) -> int:
        # write your code here
        if costs == []:
            return 0
        n = len(costs)
        costR = costs[n-1][0]
        costB = costs[n-1][1]
        costG = costs[n-1][2]
        for i in range(n-2, -1, -1):
            tempR = costR
            costR = costs[i][0] + min(costB, costG)
            tempB = costB
            costB = costs[i][1] + min(tempR, costG)
            costG = costs[i][2] + min(tempB, tempR)
        return min(costB, costG, costR)

#time complexity O(n)
#Space complexity O(1)