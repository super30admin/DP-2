'''
Approach: Recursive
TC: O(3*2^n)
SC: recusive stack

'''
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == [[]] or len(costs) == 0:
            return 0

        case1 = self.helper(costs, 0, 0, 0)
        case2 = self.helper(costs, 0, 1, 0)
        case3 = self.helper(costs, 0, 2, 0)

        return min(case1, case2, case3)

    def helper(self, costs, r, colour, minCost):

        #base case
        if r == len(costs):
            return minCost

        #logic
        if colour == 0:
            op1 = self.helper(costs, r+1, 1, minCost + costs[r][0])
            op2 = self.helper(costs, r+1, 2, minCost + costs[r][0])
            return min(op1, op2)
        if colour == 1:
            op1 = self.helper(costs, r+1, 0, minCost + costs[r][1])
            op2 = self.helper(costs, r+1, 2, minCost + costs[r][1])
            return min(op1, op2)
        if colour == 2:
            op1 = self.helper(costs, r+1, 1, minCost + costs[r][2])
            op2 = self.helper(costs, r+1, 0, minCost + costs[r][2])
            return min(op1, op2)    
'''
'''
Approach: Bottom up DP
by storing indexes of the minimum from the bottom row
TC: O(m); m = number of houses
SC: O(1)
'''
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == [[]] or len(costs) == 0:
            return 0

        n = len(costs)

        for i in range(n-2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][1], costs[i+1][0])

        return(min(costs[0][0], costs[0][1], costs[0][2]))
'''
'''
Optimizing space from previous
not mutating in the same list
'''


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == [[]] or len(costs) == 0:
            return 0

        n = len(costs)
        dp = [[0, 0, 0]] * (n)
        # print(dp)
        c1 = costs[n - 1][0]
        c2 = costs[n - 1][1]
        c3 = costs[n - 1][2]

        for i in range(n - 2, -1, -1):
            temp1 = c1
            temp2 = c2
            c1 = costs[i][0] + min(c2, c3)
            c2 = costs[i][1] + min(c3, temp1)
            c3 = costs[i][2] + min(temp1, temp2)

        return (min(c1, c2, c3))
