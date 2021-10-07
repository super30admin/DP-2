#Time Complexity = O(n)
#Space Complexity = O(1)
#compiled and run on leetcode

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if (costs == None and len(costs) == 0 and len(costs[0]) == 0):
            return 0

        n = len(costs) #no of houses

        for i in range(1, n): #start from 2nd row
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2]) #paint red
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2]) #paint blue
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1]) #paint green

        return (min(costs[n - 1][0], costs[n - 1][1], costs[n - 1][2])) #last row gives min cost